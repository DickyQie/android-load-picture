package com.zhangqie.networkimageloading.xutis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.zhangqie.networkimageloading.R;

public class XUtilsActivity extends Activity {

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpconnection);
		imageView = (ImageView) findViewById(R.id.img);
		ViewUtils.inject(this);// 注入view和事件
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		BitmapUtils bitmapUtils = new BitmapUtils(this);
		// 加载网络图片
		bitmapUtils.display(imageView,
				"http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg");

		// 加载本地图片(路径以/开头， 绝对路径)
		// bitmapUtils.display(imageView, "/sdcard/test.jpg");

		// 加载assets中的图片(路径以assets开头)
		// bitmapUtils.display(imageView, "assets/img/wallpaper.jpg");

	}
}
