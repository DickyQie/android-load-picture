package pacassodemo.zq.com.pacassodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import pacassodemo.zq.com.pacassodemo.recyclerview.Images;
import pacassodemo.zq.com.pacassodemo.recyclerview.ListViewPicassoActivity;

import static com.squareup.picasso.MemoryPolicy.NO_CACHE;
import static com.squareup.picasso.MemoryPolicy.NO_STORE;
import static com.squareup.picasso.Picasso.Priority.HIGH;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageView iv1,iv2,iv3,iv4,iv5,iv6,img8;
    String path2 = "/storage/emulated/legacy/Tencent/MobileQQ/qbiz/html5/165/s2.url.cn/"
            + "qqweb/m/relativegroup/css/image/a.png";
    private RecyclerImageView recyclerImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView()
    {
        iv1= (ImageView) findViewById(R.id.img1);
        iv2= (ImageView) findViewById(R.id.img2);
        iv3= (ImageView) findViewById(R.id.img3);
        iv4= (ImageView) findViewById(R.id.img4);
        iv5= (ImageView) findViewById(R.id.img5);
        iv6= (ImageView) findViewById(R.id.img6);
        img8= (ImageView) findViewById(R.id.img8);
        recyclerImageView= (RecyclerImageView) findViewById(R.id.img9);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn1: //加载本地图片
                int resourceId = R.mipmap.ic_launcher;
                Picasso.with(this).load(resourceId).into(iv1);
                break;
            case R.id.btn2://加载SD卡图片iv
                File file = new File(path2);
                Picasso.with(this).load(file).into(iv2);
                break;
            case R.id.btn3://网络基本图片加载
                Picasso.with(this).load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg").into(iv3);
                break;
            case R.id.btn4://调用 .centerCrop()裁剪
                Picasso.with( this).load(Images.imageThumbUrls[2]).resize(99,99).centerInside().into(iv4);
                break;
            case R.id.btn5:
                Picasso.with(this)
                        .load(Images.imageThumbUrls[1])
                        .placeholder(R.mipmap.ic_launcher)//默认显示图片
                        .error(R.mipmap.ic_launcher)//加载时出现错误显示的图片
                        .into(iv5);
                break;
            case R.id.btn6:
                Picasso.with(this)//查看大图放弃缓存，加速内存的回收
                        .load(Images.imageThumbUrls[3])
                        .memoryPolicy(NO_CACHE, NO_STORE)
                        .into(iv6);
                break;
            case R.id.btn7:
                /***
                 * 如果调用了该API, Picasso会对图片的大小及ImageView进行测量,
                 * 计算出最佳的大小及最佳的图片质量来进行图片展示,减少内存,并对视图没有影响;
                 */
                Picasso
                        .with(this)
                        .load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg")
                        .fit()
                        .into(img8);
                break;
            case R.id.btn8:
                /**
                 *  重写ImageView的onDetachedFromWindow方法，在它从屏幕中消失时回调，去掉drawable引用，能加快内存的回收。
                 *  priority()设置图片加载的优先级
                 * 如果一个屏幕上顶部图片较大,而底部图片较小,因为Picasso是异步加载,所以小图会先加载出来,但是对于用户来说,更希望看到的是上面的图片先加载,
                 * 底部的图片后加载,Picasso支持设置优先级,分为HIGH, MEDIUM, 和 LOW,所有的加载默认优先级为MEDIUM;
                 */
                Picasso
                        .with(this)
                        .load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg")
                        .priority(HIGH)
                        .into(recyclerImageView);
                break;
            case R.id.btn9:
               startActivity( new Intent(MainActivity.this, ListViewPicassoActivity.class));
                break;
        }
    }


}
