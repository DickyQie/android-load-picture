#### android--------Universal-Image-Loader图片加载框架和结合LruCache缓存图片 

<p>本博客包含包含Android-Universal-Image-Loader 网络图片加载框架实现图片加载和结合universal-image-loader与LruCache来自定义缓存图片，可以设置缓存与不缓存。</p> 
<p>Android-Universal-Image-Loader是一个开源的UI组件程序，该项目的目的是提供一个可重复使用的仪器为异步图像加载，缓存和显示。是个主流的应用，很多应用都有用到，如：天猫，淘宝等。</p> 
<p>&nbsp;</p> 
<p>&nbsp;</p> 
<p>Universal-Image-Loader源码分析：<a href="https://github.com/nostra13/Android-Universal-Image-Loader" target="_blank" rel="nofollow">https://github.com/nostra13/Android-Universal-Image-Loader</a></p> 
<p>jar包下载：<a href="http://download.csdn.net/detail/dickyqie/9768781" rel="nofollow">Universal-Image-Loader.jar下载</a></p> 
<p>&nbsp;</p> 
<p><span style="color:#000000">效果图博客查看： </span></p> 
<p>&nbsp;<a href="https://my.oschina.net/zhangqie/blog/849045" target="_blank" rel="nofollow">Universal-Image-Loader图片加载框架和结合LruCache缓存图片 </a></p> 
<p>&nbsp;</p> 
<p>&nbsp;</p> 
<p>由效果图可以看到第一次加载和第二次加载是不一样的，第一次加载是从服务器端获取，其中将他缓存了下来，第二次加载时就会和第一次加载比较，相同的就从缓存中获取，新的图片则重新到服务器端获取，从而提高效率，减少用户流量。</p> 
<p>&nbsp;</p> 

