package yanxiu.com.yxyl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import yanxiu.com.adapter.CityAdapter;
import yanxiu.com.adapter.RegionItem;
import yanxiu.com.adapter.RegionItemAdapter;

public class ChooseRegion extends AppCompatActivity {
    private List<RegionItem> yxylRegions=new ArrayList<>();
    private List<RegionItem> citys=new ArrayList<>();
    private List<RegionItem> countys=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_region);
        initRegionsProvice();
        RegionItemAdapter yxylRegionsAdapter=new RegionItemAdapter(this,R.layout.provinceitem,yxylRegions);
        /*CityAdapter cityAdapte=new CityAdapter(this,R.layout.cityitem,citys);*/
        ListView listView=(ListView)findViewById(R.id.list_province_item);
        listView.setAdapter(yxylRegionsAdapter);
        initRegionsCity();




    }
    //初始化数据
   private void initRegionsProvice() {
       int i = 0;
       /*RegionItem  sichuan=new RegionItem("四川","绵阳市","三台县");
       yxylRegions.add(sichuan);
       RegionItem  chongqing=new RegionItem("重庆","北碚区","市辖区");
       yxylRegions.add(chongqing);
       RegionItem  beijing=new RegionItem("北京","北京","西城区");
       yxylRegions.add(beijing);*/
       for (; i < 9; i++) {
           RegionItem sichuan = new RegionItem("四川");
           yxylRegions.add(sichuan);
           RegionItem chongqing = new RegionItem("重庆");
           yxylRegions.add(chongqing);
           RegionItem beijing = new RegionItem("北京");
           yxylRegions.add(beijing);


       }
   }
    private void initRegionsCity(){
        int i=0;
       /*RegionItem  sichuan=new RegionItem("四川","绵阳市","三台县");
       yxylRegions.add(sichuan);
       RegionItem  chongqing=new RegionItem("重庆","北碚区","市辖区");
       yxylRegions.add(chongqing);
       RegionItem  beijing=new RegionItem("北京","北京","西城区");
       yxylRegions.add(beijing);*/
        for(;i<9;i++){
            RegionItem  sichuan=new RegionItem("成都");
            yxylRegions.add(sichuan);
            RegionItem  chongqing=new RegionItem("重庆");
            yxylRegions.add(chongqing);
            RegionItem  beijing=new RegionItem("北京");
            yxylRegions.add(beijing);


        }


    }

}
