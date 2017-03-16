# Android图片加载框架之Picasso非常好的图片加载缓存库
 <p><strong><span style="color:rgb(0, 0, 0)">简介：</span></strong></p> 
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
<p><strong><span style="color:#000000">案例功能介绍</span></strong></p> 
<p>1：加载本地图片</p> 
<pre><code class="language-java"> int resourceId = R.mipmap.ic_launcher;
 Picasso.with(this).load(resourceId).into(iv1);</code></pre> 
<p>2：加载SD卡图片</p> 
<pre><code class="language-java">  File file = new File(path2);
  Picasso.with(this).load(file).into(iv2);</code></pre> 
<p>3：普通加载网络图片</p> 
<pre><code class="language-java">Picasso.with(this).load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg").into(iv3);</code></pre> 
<p>4:加载图片并裁剪</p> 
<pre><code class="language-java"> Picasso.with( this).load("url").resize(99,99).centerInside().into(iv4);</code></pre> 
<p>5:初始化图片和错误时的图片</p> 
<pre><code class="language-java"> Picasso.with(this).load("url")
                   .placeholder(R.mipmap.ic_launcher)//默认显示图片
                   .error(R.mipmap.ic_launcher)//加载时出现错误显示的图片
                   .into(iv5);</code></pre> 
<p>6:加载图片过大要放弃缓存（ <span style="color:rgb(128, 0, 0)">Picasso默认会使用设备的15%的内存作为内存图片缓存，且现有的api无法清空内存缓存。我们可以在查看大图时放弃使用内存缓存，图片从网络下载完成后会缓存到磁盘中，加载会从磁盘中加载，这样可以加速内存的回收</span> ）</p> 
<pre><code class="language-java">Picasso.with(this).load("url")//查看大图放弃缓存，加速内存的回收
                  .memoryPolicy(NO_CACHE, NO_STORE)
                  .into(iv6);</code></pre> 
<p>7: &nbsp;<span style="color:#000000">计算出最佳的大小及最佳的图片质量来进行图片展示 (</span> &nbsp;<span style="color:#B22222">减少内存</span> <span style="color:#000000">)</span></p> 
<pre><code class="language-java"> Picasso.with(this).load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg")
                   .fit()
                   .into(img8);</code></pre> 
<p>8:自定义图片控件加载</p> 
<pre><code class="language-java">        /**
          *  重写ImageView的onDetachedFromWindow方法，在它从屏幕中消失时回调，去掉drawable引用，能加快内存的回收。
          *  priority()设置图片加载的优先级
          * 如果一个屏幕上顶部图片较大,而底部图片较小,因为Picasso是异步加载,所以小图会先加载出来,但是对于用户来说,更希望看到的是上面的图片先加载,
          * 底部的图片后加载,Picasso支持设置优先级,分为HIGH, MEDIUM, 和 LOW,所有的加载默认优先级为MEDIUM;
          */
Picasso.with(this).load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg")
                  .priority(HIGH)
                  .into(recyclerImageView);</code></pre> 
<p>9：列表加载（.tag的使用）</p> 
<pre><code class="language-java"> Picasso.with(context).load("url"])
                      .tag("RecyclerView") //参数为 Object
                      .into(viewHolder.imageView);</code></pre> 
<p>&nbsp;</p> 
<p>补充：</p> 
<pre><code class="language-java">//因为图片的旋转都是相对(0,0)进行操作,所以如果我们想自定义相对于某个点,也是可以的,只需要调用
//.rotate(float degrees, float pivotX, float pivotY)

 Picasso.with(context).load("url").rotate(90f) //旋转90度
                .into(imageViewSimpleRotate);</code></pre> 
<p><span style="background-color:rgb(255, 255, 255); color:rgb(51, 51, 51)">添加程序所需要的依赖：</span></p> 
<pre><code class="language-java">compile 'com.squareup.picasso:picasso:2.5.2'</code></pre> 
<p>AndroidManifest.xml添加权限</p> 
<pre><code class="language-html">    &lt;uses-permission android:name="android.permission.INTERNET" /&gt;
    &lt;uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /&gt;
    &lt;uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" /&gt;
    &lt;uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /&gt;</code></pre> 
<p>&nbsp;</p> 
