package com.example.du.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.du.listviewdemo.Fruit;

import java.util.List;

/**
 * Created by dutingting on 2017/5/31.
 */
/*自定义一个FruitAdapter适配器继承ArrayAdapter*/
public class FruitAdapter extends ArrayAdapter<Fruit>{
    private  int resourceid;
    public FruitAdapter(Context context, int textViewId, List<Fruit> fruits){

        super(context,textViewId,fruits);
        resourceid=textViewId;


    }
    @Override
    public View getView(int position , View converView, ViewGroup parent){
        Fruit fruit=getItem( position);//获取当前的实例
        View view= LayoutInflater.from( getContext()).inflate(resourceid,parent,false);
        ImageView fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitText=(TextView) view.findViewById(R.id.fruit_name);
        TextView fruitId=(TextView) view.findViewById(R.id.fruit_price);
        fruitImage.setImageResource(fruit.getImageId());
        fruitText.setText(fruit.getName());
        fruitId.setText(fruit.getPrice());
    return  view;
    }
}
