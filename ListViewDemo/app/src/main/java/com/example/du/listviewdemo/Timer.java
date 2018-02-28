package com.example.du.listviewdemo;

//import android.icu.util.Calendar;
import java.util.Calendar;//因为android.icu.util.calendar 是代替java.util.Calendar，但是android.icu.util.calendar只允许使用在API24以上
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class Timer extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar calendar;
    private int year;
    private  int month;
    private int day;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        //实例化calendar对象
        calendar=Calendar.getInstance();
        //获取当前的年月日信息
        /*year=calendar.get(Calendar.YEAR);

        month=calendar.get(Calendar.MONTH)+1;//获取是从0开始的，所有要加1  具体的源码我也不知道
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR_OF_DAY);
        minute=calendar.get(Calendar.MINUTE);*/
//        setTitle(year+":"+month+":"+day+":"+hour+":"+minute);
        datePicker= (DatePicker) findViewById(R.id.datepicker);//alt+enter强制转
        timePicker= (TimePicker) findViewById(R.id.timerpicker);
        year=datePicker.getYear();
        month=datePicker.getMonth()+1;
        day=datePicker.getDayOfMonth();
        setTitle(year+"年"+month+"月"+day+"日");
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                setTitle(hourOfDay+":"+minute);
            }
        });


    }
}
