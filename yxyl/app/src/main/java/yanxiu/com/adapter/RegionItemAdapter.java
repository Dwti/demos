package yanxiu.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import yanxiu.com.yxyl.R;

/**
 * Created by dutingting on 2017/6/19.
 */

public  class RegionItemAdapter extends ArrayAdapter<RegionItem> {
    private  int resourceid;
    public RegionItemAdapter(Context context, int textViewId, List<RegionItem> regions){
        super(context,textViewId,regions);
        resourceid=textViewId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RegionItem regions=getItem(position);
        View view= LayoutInflater.from( getContext()).inflate(resourceid,parent,false);
        TextView province= (TextView) view.findViewById(R.id.province_text);
        TextView city= (TextView) view.findViewById(R.id.city_text);
        TextView county= (TextView) view.findViewById(R.id.county_text);
        province.setText(regions.getmProvince());
//        city.setText(regions.getmCity());
//        county.setText(regions.getmCounty());
        return view;
    }

}
