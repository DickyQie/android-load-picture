package com.zhangqie.networkimageloading.httpclients;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Util {
	
	
	
	/**
	 * 图片加载
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getImageBitmap(String url) {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse resp = httpclient.execute(httpget);
			// 判断是否正确执行
			if (HttpStatus.SC_OK == resp.getStatusLine().getStatusCode()) {
				// 将返回内容转换为bitmap
				HttpEntity entity = resp.getEntity();
				InputStream in = entity.getContent();
				Bitmap mBitmap = BitmapFactory.decodeStream(in);
				// 向handler发送消息，执行显示图片操作
				return mBitmap;
			}

		} catch (Exception e) {
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return null;
	}
	

}
