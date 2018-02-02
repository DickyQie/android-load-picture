package com.zhangqie.networkimageloading.httpurlconnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.zhangqie.networkimageloading.R;


public class HttpConnectionActivity extends Activity{
	
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpconnection);
		imageView=(ImageView) findViewById(R.id.img);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new DownImgAsyncTask()
						.execute("http://avatar.csdn.net/8/6/0/2_dickyqie.jpg");
			}
		}).start();
	}
	
	

	class DownImgAsyncTask extends AsyncTask<String, Void, Bitmap> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

		}

		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			Bitmap b = Util.getImageBitmap(params[0]);
			return b;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result != null) {
				imageView.setImageBitmap(result);
			}
		}

	}
	
	

}
