package com.example.du.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter arrayAdapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        textView= (TextView) findViewById(R.id.spinner_textview);
        spinner= (Spinner) findViewById(R.id.spinner);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        //设置数据源
        list=new ArrayList<String>();
        list.add("beijing");
        list.add("shanghai");
        list.add("guangzhou");
        list.add("shengzhen");
        list.add("chengdu");

        //新建adapter 使用ArrayAdapter
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);//ctrl+鼠标左键查看源码
        //adapter设置下拉列表的样式
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arrayAdapter);
        //设置监听器
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textView.setText("请选择"+arrayAdapter.getItem(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ProgressBarActivity.class);
        startActivity(intent);


    }
}
