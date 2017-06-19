package yanxiu.com.adapter;


import android.content.Context;
import android.view.LayoutInflater;


/**
 * Created by srt-k12001 on 2017/6/19.
 */

public class RegionItem {
    private  String mProvince;
//    private  String mCity;
//    private  String mCounty;

    public RegionItem(String province){
        this.mProvince=province;
//        this.mCity=city;
//        this.mCounty=county;
    }

    public String getmProvince() {
        return mProvince;
    }

//    public String getmCity() {
//        return mCity;
//    }
//
//    public String getmCounty() {
//        return mCounty;
//    }


}
