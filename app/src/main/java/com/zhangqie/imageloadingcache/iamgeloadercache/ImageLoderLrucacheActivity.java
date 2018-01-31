package com.zhangqie.imageloadingcache.iamgeloadercache;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.zhangqie.imageloadingcache.R;

/****
 * 
 * 结合universal-image-loader和LruCache来缓存加载的图片
 * 可以设置缓存与不缓存
 * 
 * @author 
 *
 */
public class ImageLoderLrucacheActivity extends Activity{
	
	ImageView imageview1,imageview2,imageview3;
	private ImageLoader mImageLoader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageloder_main);
		initView();
		
	}
	private void initView() {
		// TODO Auto-generated method stub
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		mImageLoader = ImageLoader.getInstance(3, ImageLoader.Type.LIFO);
		/***
		 * 第一个参数：Url
		 * 第二个参数：图片实例
		 * 第三个参数：是否缓存
		 * 
		 */
		mImageLoader.loadImage("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg", imageview1, true);
		mImageLoader.loadImage("http://tnfs.tngou.net/image/info/150729/d9ae7426fef7f2d58c190cffab6ad5f7.png", imageview2, true);
		mImageLoader.loadImage("http://tnfs.tngou.net/image/info/150729/c96da5303be57a916e62ca79ecb9930d.jpg", imageview3, true);
	}
	

}
