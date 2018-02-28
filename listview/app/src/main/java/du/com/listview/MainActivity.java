package du.com.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private SimpleAdapter msubjectAdapter;
    private List<Map<String,Object>> data;
    public  HomeWorkResponse mhomeWorkResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapt();
        listener();
    }

    private void listener() {
        mListView.setOnItemClickListener(this);
    }

    void initAdapt(){

        String[] from=new String[]{"subjectName","Status"};
        int[] to=new int[]{R.id.tv_subject,R.id.tv_isstatus};
        msubjectAdapter=new SimpleAdapter(this,initData(),R.layout.subject_item,from,to);
        mListView.setAdapter(msubjectAdapter);



    }

    //创建数据
    private  List<Map<String,Object>> initData(){
        String [] s=new String[]{"数学","英语","化学","语文"};
        data =new ArrayList<Map<String, Object>>();
        for(int i=0;i<s.length;i++){
            Map<String,Object> map =new HashMap<String,Object>();

            map.put("subjectName",s[i]);
            map.put("Status","2份未完成");
            data.add(map);

        }
        return data;

    }

    void initView(){
      mListView= (ListView) findViewById(R.id.lv_subjects);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final HomeworkRequest homeworkRequest=new HomeworkRequest();
//        HomeWorkCallback callback=new HomeWorkCallback();

        homeworkRequest.startRequest(HomeWorkResponse.class, new HttpCallback<HomeWorkResponse>() {
            /**
             * @param request
             * @param ret
             */
            @Override
            public void onSuccess(RequestBase request, HomeWorkResponse ret) {
                Log.d("hahhahahhaha","suncessc成功");
                ArrayList<String> names=new ArrayList<String>();
                if (ret.getStatus().getCode()==0){
                    Log.d("hahhahahhaha",ret.getData().get(0).getAuthorid());
                      mhomeWorkResponse=ret;

                    for (HomeworkDetailBean paper:ret.getData()) {
                        names.add(paper.getName());

                    }
                    Intent intent=new Intent(MainActivity.this,HomeworkActivity.class);//启动活动
                    intent.putExtra("name",ret.getData().get(0).getName());//传递数据
                    intent.putStringArrayListExtra("names",names);
                    intent.putExtra("data",(Serializable) ret.getData());//反序列化，自定义的数据  需要反序列化传递
//                    startActivity(intent);
                    //在不知道要传入什么参数的情况下启动activity的方式
                    HomeworkActivity.actionStart(this,(Serializable) ret.getData());
                }
                if(ret.getStatus().getCode()==99){
                    Log.i("dutt",ret.getStatus().getDesc().toString());

                }
            }

            @Override
            public void onFail(RequestBase request, Error error) {
                return;

            }

        });


    }
}
