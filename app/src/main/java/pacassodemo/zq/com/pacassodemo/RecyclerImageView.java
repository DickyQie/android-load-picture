package pacassodemo.zq.com.pacassodemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by zq on 2017/1/11.
 */

public class RecyclerImageView extends ImageView {


    public RecyclerImageView(Context context) {
        this(context,null);
    }

    public RecyclerImageView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public RecyclerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }

}
