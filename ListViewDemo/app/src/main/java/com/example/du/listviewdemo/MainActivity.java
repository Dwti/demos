package com.example.du.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener ,OnScrollListener{
    private List<Fruit> myFruit=new ArrayList<>();
    private ArrayAdapter<String>  arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> data;
    private  ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**/
//        initFruits();
//        FruitAdapter fruitAdapter=new FruitAdapter(this,R.layout.fruit_item,myFruit);


//        listView.setAdapter(fruitAdapter);
//        1.创建一个数据适配器
        /*ArrayAdapter<String>(上下文，当前每一个列表项所对应的布局文件，数据源)*/
        String[] arrdata={"北京","上海","深圳"};
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrdata);
//        2.适配器加载数据源
//        3、视图加载适配器
        /*
        SimpleAdapter():
        context:上下文
        * dataList<?extends map<String,?>>:一个map所组成的一个list集合，每一给map对应listview的一行
        * 每一个map的键必须包含所有在from中所指定的键
        * resource:int 列表的布局文件ID
        * from:String[]map中的键名
        * to:int[]：绑定视图中的id，跟from对应 value
        * */
        data =new ArrayList<Map<String, Object>>();
        String []from=new String[]{"image","name","price"};
        int [] to=new int[]{R.id.fruit_image,R.id.fruit_name,R.id.fruit_price};
        simpleAdapter=new SimpleAdapter(this,initdata(),R.layout.fruit_item,from,to);
//        listView.setAdapter(arrayAdapter);

        listView=(ListView) findViewById(R.id.list_item);
        listView.setAdapter(simpleAdapter);
        //加载事件监听器
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);













        /*ArrayList<String> furitlist= new ArrayList<>();
        furitlist.add("apple");
        furitlist.add("香蕉");
        furitlist.add("apple");
        furitlist.add("香蕉");
        furitlist.add("apple");
        furitlist.add("香蕉");
        furitlist.add("apple");
        furitlist.add("香蕉");
        furitlist.add("apple");
        furitlist.add("香蕉");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,furitlist);
        ListView listView=(ListView) findViewById(R.id.list_item);
        listView.setAdapter(arrayAdapter);
    }*/


    }
//    初始化数据
    private List<Map<String,Object>> initdata(){

        for(int i=0;i<20;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",R.mipmap.ic_launcher);
            map.put("name","苹果"+i);
            map.put("price","7.0");
            data.add(map);
        }
        return data;
    }
    /*初始化水果数据*/
    private void initFruits(){
        int i=0;
        for(;i<3;i++){
            Fruit apple=new Fruit("apple",R.drawable.apple,"8.00");
            myFruit.add(apple);
            Fruit banana=new Fruit("apple",R.drawable.apple,"3.50");
            myFruit.add(apple);
            Fruit orange=new Fruit("apple",R.drawable.apple,"10.00");
            myFruit.add(apple);
            Fruit pear=new Fruit("apple",R.drawable.apple,"7.89");
            myFruit.add(apple);
            Fruit mango=new Fruit("apple",R.drawable.apple,"7.90");
            myFruit.add(apple);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String message=listView.getItemAtPosition(position)+""+id;
        Log.i(message,"点击了每个列表项");

    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState){
            //用户在手指离开屏幕之前用力地滑动了屏幕一下，视图任然在滑动
            case SCROLL_STATE_FLING:
                Log.i(" Main","用户在手指离开屏幕之前用力地滑动了屏幕一下，视图任然在滑动");
                /*Map<String,Object> map1=new HashMap<String,Object>();
                map1.put("image",R.mipmap.ic_launcher);
                map1.put("name","香蕉");
                map1.put("price","3.5");
                data.add(map1);
                //通知UI改变了，没有这个会crash的
                simpleAdapter.notifyDataSetChanged();*/
                Intent intent=new Intent(this,GridViewActivity.class);
                startActivity(intent);

                break ;
            case SCROLL_STATE_IDLE:
                Log.i(" Main","view停止滑动");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i(" Main","手指没离开屏幕，视图正在滑动中");
                break;
        }


    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
