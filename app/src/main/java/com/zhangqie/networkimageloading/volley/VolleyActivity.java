package com.zhangqie.networkimageloading.volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.zhangqie.networkimageloading.R;

public class VolleyActivity extends Activity implements OnClickListener{
	
	ImageView imageview1,imageview2;
	NetworkImageView networkImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volley);
		initView();
	}
	private void initView(){
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		networkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			setImg1();
			break;
		case R.id.button2:
			setImg2();
			break;
		case R.id.button3:
			setImg3();
			break;
		default:
			break;
		}
	}
	/***
	 * ImageRequest加载图片
	 */
	public void setImg1()
	{
		
		
		ImageRequest request = new ImageRequest(VolleySingleton.imageThumbUrls[0],
		    new Response.Listener<Bitmap>() {
		        @Override
		        public void onResponse(Bitmap bitmap) {
		        	imageview1.setImageBitmap(bitmap);
		        }
		    }, 0, 0, Config.RGB_565,
		    new Response.ErrorListener() {
		        public void onErrorResponse(VolleyError error) {
		        	imageview1.setImageResource(R.mipmap.ic_launcher);
		        }
		    });
		    VolleySingleton.getVolleySingleton(this.getApplicationContext()).addToRequestQueue(request);
	}
	/***
	 * 使用 ImageLoader 加载图片
	 */
	
	public void setImg2()
	{
		com.android.volley.toolbox.ImageLoader mImageLoader;
		mImageLoader = VolleySingleton.getVolleySingleton(this.getApplicationContext()).getImageLoader();
		mImageLoader.get(VolleySingleton.imageThumbUrls[1], 
				//mImageView是ImageView实例
				//第2个参数：默认图片
				//第2个参数：加载图片错误时的图片
		com.android.volley.toolbox.ImageLoader.getImageListener(imageview2,R.mipmap.ic_launcher, R.mipmap.ic_launcher));
	}
	/**
	 * 使用NetworkImageView加载图片
	 */
	public void setImg3()
	{
		com.android.volley.toolbox.ImageLoader mImageLoader;
		mImageLoader = VolleySingleton.getVolleySingleton(this.getApplicationContext()).getImageLoader();
		networkImageView.setImageUrl(VolleySingleton.imageThumbUrls[2], mImageLoader);
	}	
	
	
	
	

}
