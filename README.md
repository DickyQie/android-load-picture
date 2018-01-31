#### Android图片加载框架之Picasso非常好的图片加载缓存库

<p><span style="color:rgb(0, 0, 0)">Picasso是Square公司开源的一个Android图形缓存库， 可以实现图片加载（本地和网络）和缓存功能。</span></p> 
<p><span style="color:rgb(0, 0, 0)">地址：</span><a href="http://square.github.io/picasso/" rel="nofollow"><span style="color:#008080">http://square.github.io/picasso/</span></a></p> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(0, 0, 0)">jar包下载：&nbsp;</span><a href="http://download.csdn.net/detail/dickyqie/9782415" target="_blank" rel="nofollow">Picasso.jar</a></p> 
<p><span style="color:#000000">Paicsso可以实现图片的很多功能，drawable/mipmap下图片加载，SD卡图片加载，网络图片加载（可自己设置是否缓存）,图片裁剪等。</span></p> 
<p><span style="color:#000000"><span style="background-color:rgb(255, 255, 255)">Picasso实现了图片的异步加载,并解决了Android中加载图片时常见的一些问题,它有以下特点:</span></span></p> 
<ol> 
 <li><span style="color:#000000">在Adapter中取消了不在视图范围内的ImageView的资源加载,因为可能会产生图片错位;</span></li> 
 <li><span style="color:#000000">使用复杂的图片转换技术降低内存的使用</span></li> 
 <li><span style="color:#000000">自带内存和硬盘的二级缓存机制</span></li> 
</ol> 
<p><span style="color:#000000">效果如图：</span></p> 
<p><span style="color:#000000"><img alt="" src="https://static.oschina.net/uploads/space/2017/0315/175756_RGyf_2945455.gif"></span></p> 

