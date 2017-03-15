package pacassodemo.zq.com.pacassodemo.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pacassodemo.zq.com.pacassodemo.R;


/**
 * Created by zq on 2017/1/11.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    public List<String> datas = null;
    private Context context;
    public Adapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context=context;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo1_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(datas.get(position));
        Picasso.with(context)
                .load(Images.imageThumbUrls[position])
                .tag("RecyclerView") //参数为 Object
                .into(viewHolder.imageView);
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }





    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;
        public ImageView imageView;
        public ViewHolder(View view)
        {
            super(view);
            mTextView=(TextView)view.findViewById(R.id.textview1);
            imageView= (ImageView) view.findViewById(R.id.imageViewitem);
        }

    }
}
