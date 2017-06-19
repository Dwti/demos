package yanxiu.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import yanxiu.com.yxyl.R;

/**
 * Created by srt-k12001 on 2017/6/19.
 */

public class CityAdapter extends ArrayAdapter<RegionCityItem> {
    private int resourceid;

    public CityAdapter(Context context, int textViewId, List<RegionCityItem> citys) {
        super(context, textViewId, citys);
        resourceid = textViewId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RegionCityItem citys=getItem(position);
        View view= LayoutInflater.from( getContext()).inflate(resourceid,parent,false);
        TextView province= (TextView) view.findViewById(R.id.province_text);
        TextView city= (TextView) view.findViewById(R.id.city_text);
        TextView county= (TextView) view.findViewById(R.id.county_text);
//        province.setText(regions.getmProvince());
        city.setText(citys.getmCity());
//        county.setText(regions.getmCounty());
        return view;
    }
}