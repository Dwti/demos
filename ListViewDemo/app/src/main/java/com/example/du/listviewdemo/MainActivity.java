package com.example.du.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> myFruit=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**/
        initFruits();
        FruitAdapter fruitAdapter=new FruitAdapter(this,R.layout.fruit_item,myFruit);
        ListView listView=(ListView) findViewById(R.id.list_item);
        listView.setAdapter(fruitAdapter);











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
}
