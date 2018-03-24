package com.du.litepaltest;

import android.animation.ObjectAnimator;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import beans.Student;

public class MainActivity extends AppCompatActivity {
    private Button mCreateDatabase,mInsertdata,mSelectdata,mUpdatedata,mDeletedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        listener();
    }

    private void listener() {
        mCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                Log.i("duduudu","hhhhhhh");
            }
        });
        mInsertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student s1=new Student();
                s1.setAge(27);
                s1.setName("小明");
                s1.setSchool("北京大学");
                s1.setSex("男");
                s1.save();
                Log.i("duduudu","添加数据成功");
            }
        });
        mUpdatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student s2=new Student();
                s2.setAge(23);
                //更新字段的默认值使用是s2.setToDefault("name");
                s2.setSchool("清华大学");
                s2.updateAll("name=? and sex=?","小明","男");
                Log.i("duduudu","更新数据成功");
            }
        });
        mDeletedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Student s3=new Student();
                s3.delete();*/
                DataSupport.deleteAll(Student.class,"age>?","20");
                Log.i("duduudu","删除数据成功");
            }
        });
        mSelectdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> studentList=DataSupport.findAll(Student.class);
                for(Student s:studentList){
                    Log.d("Student的name",s.getName());
                    Log.d("Student的sex",s.getSex());
                }
            }
        });
    }

    private void initData() {
    }

    private void initView() {
        mCreateDatabase=findViewById(R.id.bt_create_database);
        mSelectdata=findViewById(R.id.bt_select_data);
        mInsertdata=findViewById(R.id.bt_insert_data);
        mUpdatedata=findViewById(R.id.bt_update_data);
        mDeletedata=findViewById(R.id.bt_delete_data);
    }
}
