package com.zhangqie.imageloadingcache.imageloader;


import java.io.File;  

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;  
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;  
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;  
import com.nostra13.universalimageloader.core.ImageLoader;  
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;  
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;  
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;  
import com.nostra13.universalimageloader.utils.StorageUtils;  


public class MyApplication extends Application {

	@Override  
    public void onCreate() {  
        super.onCreate();  
        initImageLoader(getApplicationContext());  
    }  
  
    public static void initImageLoader(Context context) {  
        //缓存文件的目录  
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "universalimageloader/Cache");   
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)  
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽   
                .threadPoolSize(3) //线程池内线程的数量  
                .threadPriority(Thread.NORM_PRIORITY - 2)  
                .denyCacheImageMultipleSizesInMemory()  
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密  
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))  
                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值  
                .diskCacheSize(50 * 1024 * 1024)  // SD卡缓存的最大值  
                .tasksProcessingOrder(QueueProcessingType.LIFO)  
                // 由原先的discCache -> diskCache  
                .diskCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径    
                .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) 
                .writeDebugLogs() // Remove for release app  
                .build();  
        //全局初始化此配置    
        ImageLoader.getInstance().init(config);  
    }  
	
}
