package com.zhangqie.imageloadingcache.imageloader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.zhangqie.imageloadingcache.Images;
import com.zhangqie.imageloadingcache.R;

public class ImageLoaderActivity extends Activity{
	
	private ImageLoader imageLoader;  
	private ListView mListView;
	private String[] imageUrls; 
    private DisplayImageOptions options;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageloader);
		showImg();
		initView();
	}
	private void initView() {
		 mListView=(ListView) findViewById(R.id.listView);
		 mListView.setAdapter(new ItemListAdapter(imageUrls, ImageLoaderActivity.this)); 
	}

	private void showImg() {
		 	imageLoader = ImageLoader.getInstance();  
			imageUrls = Images.imageThumbUrls;
			 // 使用DisplayImageOptions.Builder()创建DisplayImageOptions  
	         options = new DisplayImageOptions.Builder()  
	                .showImageOnLoading(R.mipmap.ic_launcher) // 设置图片下载期间显示的图片
	                .showImageForEmptyUri(R.mipmap.ic_launcher) // 设置图片Uri为空或是错误的时候显示的图片
	                .showImageOnFail(R.mipmap.ic_launcher) // 设置图片加载或解码过程中发生错误显示的图片
	                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中  
	                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中  
	                .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片  
	                .build(); // 构建完成  
	}
	 class ItemListAdapter extends BaseAdapter { 
		 	String[] img;
		 	public ItemListAdapter(String[] s,Context context) {
				this.img=s;
			}
		 
	        @Override  
	        public int getCount() {  
	            // TODO Auto-generated method stub  
	            return img.length;  
	        }  
	  
	        @Override  
	        public Object getItem(int position) {  
	            // TODO Auto-generated method stub  
	            return img[position];  
	        }  
	        @Override  
	        public long getItemId(int position) {  
	            return position;  
	        }  
	        @Override  
	        public View getView(int position, View convertView, ViewGroup parent) {  
	            ViewHolder holder = null;  
	            if (convertView == null) {  
	                convertView =getLayoutInflater().inflate(R.layout.item1, parent,false);
	                holder = new ViewHolder();  
	                holder.image = (ImageView) convertView.findViewById(R.id.mListViewImageView);  
	                holder.text1 = (TextView) convertView.findViewById(R.id.text1);  
	                convertView.setTag(holder);  
	            } else {  
	                holder = (ViewHolder) convertView.getTag();  
	            }  
	            imageLoader.displayImage(img[position], holder.image,options);  
	            holder.text1.setText(img[position]);
	            return convertView;  
	        }  
	  
	   
	  
	        class ViewHolder {  
	            public ImageView image;  
	            public TextView text1;
	        }  
	    }  

}
