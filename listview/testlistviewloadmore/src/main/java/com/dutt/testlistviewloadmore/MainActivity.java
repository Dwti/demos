package com.dutt.testlistviewloadmore;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import adapters.ListViewAdapter;
import views.LoadListView;

public class MainActivity extends AppCompatActivity  implements LoadListView.LoadmoreListener ,SwipeRefreshLayout.OnRefreshListener{
    private LoadListView mLoadListView;
    private ListViewAdapter mListViewAdapter;
    private List<String> datas=new ArrayList<>();
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdatas();
        showMoreListViewDatas(datas);
//        initView();

    }

    private void initView() {
        mLoadListView=findViewById(R.id.load_more);
        mLoadListView.setmLoadmoreListener(this);
        mListViewAdapter=new ListViewAdapter(datas,LayoutInflater.from(this));
        mLoadListView.setAdapter(mListViewAdapter);
        mSwipeRefreshLayout=findViewById(R.id.refreash_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }
//加载数据
    private void showMoreListViewDatas(List<String> list) {
        if(mListViewAdapter==null){
            initView();
        }else{
            mListViewAdapter.onDataChange(list);
        }
    }

    /**
     *
     */
    private void initdatas() {
        for(int i=0;i<20;i++){
            datas.add("88888");
        }

    }

    @Override
    public void onLoad() {
        //模拟延时效果
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                        datas.add("新增加的啦"+i);
                }
                //加载完毕了
                mLoadListView.loadComplete();
            }
        },200);
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        datas.add("hello");
                        mListViewAdapter.onDataChange(datas);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 200);
            }
        });

    }
}
