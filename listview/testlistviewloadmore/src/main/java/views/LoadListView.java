package views;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.dutt.testlistviewloadmore.R;

/**
 * Created by sunpeng on 2018/2/1.
 */

public class LoadListView extends ListView implements AbsListView.OnScrollListener {
    private View mFooterLayout;
    private int mTotalItemCount;//总数
    private int mLastVisibleItem;//最后一个可见的Item
    private boolean mIsLoding=false;//判断是否正在加载
    private LoadmoreListener mLoadmoreListener;

    public void setmLoadmoreListener(LoadmoreListener mLoadmoreListener) {
        this.mLoadmoreListener = mLoadmoreListener;
    }

    public LoadListView(Context context) {
        super(context);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }
//初始化布局文件
    private void initView(Context context) {
        LayoutInflater inflater=LayoutInflater.from(context);
        mFooterLayout=inflater.inflate(R.layout.load_more__footer_layout,null);
        this.addFooterView(mFooterLayout);
//        mFooterLayout.setVisibility(View.INVISIBLE);
        mFooterLayout.findViewById(R.id.load_more).setVisibility(INVISIBLE);

    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if(this.mTotalItemCount==mLastVisibleItem && i==SCROLL_STATE_IDLE){
            if(!mIsLoding){
                mIsLoding=true;
                mFooterLayout.findViewById(R.id.load_more).setVisibility(INVISIBLE);
                //加载数据，使用接口回调
                mLoadmoreListener.onLoad();

            }
        }

    }


    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        this.mLastVisibleItem=i+i1;
        this.mTotalItemCount=i2;

    }



    public interface LoadmoreListener{
        void onLoad();

    }
    //加载数据完成
    public  void loadComplete(){
        mIsLoding=false;
        mFooterLayout.setVisibility(View.GONE);

    }
}
