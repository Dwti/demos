package views;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import du.com.listview.R;

/**
 * Created by sunpeng on 2018/1/31.
 */

public class LoadListView extends ListView implements AbsListView.OnScrollListener{
    View footer;//底部的布局
    int mTotalItemCount,mLastItemCount;
    boolean misLoading=false;
    private LoadMoreListener mLoadMoreListener;




    public void setmLoadMoreListener(LoadMoreListener mLoadMoreListener) {
        this.mLoadMoreListener = mLoadMoreListener;
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
/*
* 添加底部加载更多的布局文件
* */
    private void initView(Context context){
        LayoutInflater inflater=LayoutInflater.from(context);
        footer=inflater.inflate(R.layout.load_more,null);
        footer.findViewById(R.id.load_more_datas).setVisibility(GONE);
        this.addFooterView(footer);//添加布局
        this.setOnScrollListener(this);//添加监听

        /*footer.setVisibility(VISIBLE);*/

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(mTotalItemCount==mLastItemCount&&scrollState==SCROLL_STATE_IDLE){
            if(!misLoading){
                footer.findViewById(R.id.load_more_datas).setVisibility(VISIBLE);
                misLoading=true;
                mLoadMoreListener.onload();
            }

        }

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.mLastItemCount=firstVisibleItem+visibleItemCount;
        this.mTotalItemCount=totalItemCount;


    }
    public void loadComplete(){
        misLoading=false;
        footer.findViewById(R.id.load_more_datas).setVisibility(GONE);
        footer.setVisibility(GONE);


    }



    //加载更多数据的接口
    public  interface LoadMoreListener{
        public void onload();
    }
}
