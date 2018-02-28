package du.com.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dutt.network.HttpCallback;
import com.dutt.network.RequestBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.HomeworkDetailBean;
import request.HomeworkRequest;
import response.HomeWorkResponse;
import views.*;

public class HomeworkActivity extends AppCompatActivity implements LoadListView.LoadMoreListener{

    private LoadListView mHomework;
    private SimpleAdapter mHomeworkAdapter;
    private ListViewAdapter mListViewAdapter;
    private List<HomeworkDetailBean> firstList=new ArrayList<HomeworkDetailBean>();
    private List<HomeworkDetailBean> nextList=new ArrayList<HomeworkDetailBean>();
    private List<Map<String,Object>> data;
    HomeWorkResponse mes=null;
    private HomeWorkResponse mhomeWorkResponse;
    private List<HomeworkDetailBean> mMoreHomeworkDetailBeans;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        /*mHomework= (ListView) findViewById(R.id.lv_homework);
        SubjectAdapt s=new SubjectAdapt(this,R.layout.homework_item);
        String[] from=new String[]{"homeworkImage","homeworkName","completeNum","homeworkDeadline","techerComment"};
        int[] to=new int[]{R.id.im_homework,R.id.tx_homeworkName,R.id.tx_completeNum,R.id.tx_homeworkDeadline,R.id.tx_techerComment};
        mHomeworkAdapter=new SimpleAdapter(this,initData(),R.layout.homework_item,from,to);
        mHomework.setAdapter(mHomeworkAdapter);*/
      initData();
      loadMoreDatas();

    }



    private void initData() {
        Intent intent=getIntent();
        List<HomeworkDetailBean> datas=new ArrayList<HomeworkDetailBean>();
//        ArrayList<String>  names=this.getIntent().getStringArrayListExtra("names");
        datas= (List<HomeworkDetailBean>) intent.getSerializableExtra("data");
        firstList=datas;
       /* for(int i=0;i<datas.size();i++){
            firstList.add(datas.get(i));
        }
*/


    }
     private void initView(){
        mHomework= (LoadListView) findViewById(R.id.lv_homework);
        mHomework.setmLoadMoreListener(this);
        mListViewAdapter=new ListViewAdapter(firstList,this);
        mHomework.setAdapter(mListViewAdapter);
        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        //下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        HomeworkRequest requestmore=new HomeworkRequest();
//                        requestmore.setPage("2");
                        requestmore.startRequest(HomeWorkResponse.class, new HttpCallback<HomeWorkResponse>() {
                            @Override
                            public void onSuccess(RequestBase request, HomeWorkResponse ret) {
                                if(ret.getStatus().getCode()==0){
                                    nextList=ret.getData();
                                    mListViewAdapter.undateView(nextList);
                                    Log.i("更新成功了，使用的是默认的下拉",ret.getStatus().getDesc().toString());
                                }
                                if(ret.getStatus().getCode()==99){
                                    Log.i("加载更多失败了",ret.getStatus().getDesc().toString());
                                }
                            }

                            @Override
                            public void onFail(RequestBase request, Error error) {
                                return;
                            }
                        });

                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });


     }
     //强制加载更多的数据
    private void loadMoreDatas(){
         if(mListViewAdapter==null){
             initView();
         }
         else {
             mListViewAdapter.undateView(firstList);
         }
    }


    @Override
    public void onload() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取更多的数据
                //更新listview
                HomeworkRequest requestmore=new HomeworkRequest();
                requestmore.setPage("2");
                requestmore.startRequest(HomeWorkResponse.class, new HttpCallback<HomeWorkResponse>() {
                    @Override
                    public void onSuccess(RequestBase request, HomeWorkResponse ret) {
                        if(ret.getStatus().getCode()==0){
                            nextList=ret.getData();
                            for(int i=0;i<nextList.size();i++){
                                firstList.add(nextList.get(i));
                            }
                            mListViewAdapter.undateView(firstList);
                    }
                        if(ret.getStatus().getCode()==99){
                            Log.i("加载更多失败了",ret.getStatus().getDesc().toString());
                        }
                    }

                    @Override
                    public void onFail(RequestBase request, Error error) {
                        return;
                    }
                });

                mHomework.loadComplete();

            }
        },2000);
    }

public static void actionStart(HttpCallback<HomeWorkResponse> context, Serializable data){
        Intent intent=new Intent((Context) context,HomeworkActivity.class);
        intent.putExtra("param1", (Serializable) data);
        ((Context) context).startActivity(intent);

}



/*
    private List<Map<String,Object>> initData() {
        Intent intent=getIntent();
//        intent.getExtras().get("name");
        data =new ArrayList<Map<String, Object>>();
        List<HomeworkDetailBean> datas=new ArrayList<HomeworkDetailBean>();
//        ArrayList<String>  names=this.getIntent().getStringArrayListExtra("names");
        datas= (List<HomeworkDetailBean>) intent.getSerializableExtra("data");

        for(int i=0;i<datas.size();i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("homeworkImage",R.drawable.homework3x);
            map.put("homeworkName",datas.get(i).getName());
            map.put("completeNum","完成题量"+datas.get(i).getVolume()+"/"+datas.get(i).getQuesnum());
            map.put("homeworkDeadline",datas.get(i).getOverTime());
            map.put("techerComment","没有");
            data.add(map);
        }
        return data;
    }*/

}
