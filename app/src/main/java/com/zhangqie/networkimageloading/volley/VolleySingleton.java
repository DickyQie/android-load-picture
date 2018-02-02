package com.zhangqie.networkimageloading.volley;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
	public final static String[] imageThumbUrls = new String[] {
		"http://avatar.csdn.net/8/6/0/2_dickyqie.jpg",
		"http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg",
		"http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg",
		"http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg",
		"http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg"
		 };
	
	 private static VolleySingleton volleySingleton;
	    private RequestQueue mRequestQueue;
	    private ImageLoader mImageLoader;
	    private Context mContext;
	    public VolleySingleton(Context context) {
	        this.mContext = context;
	        mRequestQueue = getRequestQueue();
	        mImageLoader = new ImageLoader(mRequestQueue,
	        new ImageLoader.ImageCache(){
	            @SuppressLint("NewApi") private final LruCache<String,Bitmap> cache = new LruCache<String ,Bitmap>(20);
	            @SuppressLint("NewApi") @Override
	            public Bitmap getBitmap(String url){
	                return cache.get(url);
	            }
	            @SuppressLint("NewApi") @Override
	            public void putBitmap(String url,Bitmap bitmap){
	                cache.put(url,bitmap);
	            }
	        });
	    }
	    public static synchronized VolleySingleton getVolleySingleton(Context context){
	        if(volleySingleton == null){
	            volleySingleton = new VolleySingleton(context);
	        }
	        return volleySingleton;
	    }
	    public RequestQueue getRequestQueue(){
	        if(mRequestQueue == null){
	            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
	        }
	        return mRequestQueue;
	    }
	    public <T> void addToRequestQueue(Request<T> req){
	        getRequestQueue().add(req);
	    }
	    public ImageLoader getImageLoader() {
	        return mImageLoader;
	    }
}
