package com.example.du.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private GridView gridView;
    private List<Map<String,Object>>datalist;
    private int[] icon={R.drawable.chemistry,R.drawable.biological,R.drawable.chinese,R.drawable.english,R.drawable.geography,
            R.drawable.history,R.drawable.mathematical,R.drawable.physical,
            R.drawable.political};
    private String[] iconName={"化学","生物","语文","英语","地理","历史","数学","物理","政治"};
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView= (GridView) findViewById(R.id.grid);
        /*1.创建数据源
        * 2.创建数据源: SimpleAdapter
        * 3.加载适配器:
        * 4.事件监听（）  AdapterView.OnItemClickListener*/
        datalist=new ArrayList<Map<String, Object>>();
        String []from=new String[]{"image","name"};
        int [] to=new int[]{R.id.subject_image,R.id.subject_name};
        simpleAdapter=new SimpleAdapter(this,initaData(),R.layout.subject_item,from,to);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);

    }
    private  List<Map<String,Object>> initaData(){
        for (int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("name",iconName[i]);
            datalist.add(map);
        }
            return datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("duduu",position+"");
        Intent intent=new Intent(this,SpinnerActivity.class);
        startActivity(intent);


    }
}
