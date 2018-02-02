package com.zhangqie.networkimageloading.okhttp;

import okhttp3.Call;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.zhangqie.networkimageloading.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

public class OkHttpActivity extends Activity{
	
	ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpconnection);
		imageView = (ImageView) findViewById(R.id.img);
		initView();
	}
	private void initView(){
		setIamge();
	}
	
    private void setIamge()
    {
    		String url = "http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg";
    		OkHttpUtils.get()
    				.url(url)
    				.tag(this)
    				.build()
    				.connTimeOut(20000).readTimeOut(20000).writeTimeOut(20000)
    				.execute(new BitmapCallback() {
    					@Override
    					public void onError(Call call, Exception e, int id) {
    					}

    					@Override
    					public void onResponse(Bitmap bitmap, int id) {
    						imageView.setImageBitmap(bitmap);
    					}
    				});
    }
}
