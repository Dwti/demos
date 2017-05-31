package com.example.du.listviewdemo;

import java.util.IdentityHashMap;

/**
 * Created by dutingting on 2017/5/31.
 */
/*自定义有个Furit类*/
public class Fruit {
    private  String name;
    private  int imageId;
    private  String price;
    public Fruit(String name,int imageId,String price){
        this.name=name;
        this.imageId=imageId;
        this.price=price;
    };

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getPrice() {
        return price;
    }
}
