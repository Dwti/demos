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
 * Created by srt-k12001 on 2017/6/20.
 */

public class SectionAdapter extends ArrayAdapter<Section> {
    private  int resourceid;
    public SectionAdapter(Context context, int textViewId, List<Section> sections){
        super(context,textViewId,sections);
        resourceid=textViewId;

    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
            Section section=getItem(position);//获取当前的实例
            View view= LayoutInflater.from(getContext()).inflate(resourceid,parent,false);
            TextView sectionView=(TextView) view.findViewById(R.id.section_text);
            sectionView.setText(section.getmSection());
        return view;
    }
}
