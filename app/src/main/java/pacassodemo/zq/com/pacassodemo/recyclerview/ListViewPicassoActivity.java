package pacassodemo.zq.com.pacassodemo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pacassodemo.zq.com.pacassodemo.R;


/**
 * Created by zq on 2017/1/11.
 */

public class ListViewPicassoActivity extends Activity{
    RecyclerView recyclerView;
    private List<String> mDatas;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);
        initData();
        initView();
    }
    private void initView()
    {
        recyclerView=(RecyclerView) findViewById(R.id.demo1_recycler);
        // 设置布局管理LayoutManager
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //设置水平或者垂直
       // manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        // （可选）如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        // 设置Adapter
        adapter=new Adapter(mDatas,this);
        recyclerView.setAdapter(adapter);
        /****
         * 暂停标记 pauseTag()   点击查看详情时（先看详情在）
         可见标记 resumeTag()
         取消标记 cancleTag()
         如果tag状态为pause或者resume的话,Picasso会对tag持有一个引用,如果此时用户退出了当前Activity,
         垃圾回收机制进行回收的时候,就会出现内存泄露,所以需要在onDestory()方法中进行相应处理;*/

        //RecyclerView滑动时监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                final Picasso picasso = Picasso.with(ListViewPicassoActivity.this);
                if (newState  == RecyclerView.SCROLL_STATE_IDLE) {
                    picasso.resumeTag("RecyclerView");
                } else {
                    picasso.pauseTag("RecyclerView");
                }
            }
        });
    }
    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i <= 19; i++) {
            mDatas.add("item---" +i);
        }
    }


}
