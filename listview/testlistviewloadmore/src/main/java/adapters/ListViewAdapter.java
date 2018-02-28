package adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.dutt.testlistviewloadmore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunpeng on 2018/2/1.
 */

public class ListViewAdapter extends BaseAdapter{
    List<String> datas=new ArrayList<String>();
    LayoutInflater inflater;

    public ListViewAdapter(List<String> datas, LayoutInflater inflater) {
        this.datas = datas;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View loadview=null;
        ViewHolder holder;
        if(view==null){
            loadview=inflater.inflate(R.layout.load_listview_item,null,false);
            holder=new ViewHolder();
            holder.textView=loadview.findViewById(R.id.item_tx);
            loadview.setTag(holder);

        }else {
            loadview=view;
            holder= (ViewHolder) loadview.getTag();
        }
        //添加数据
        holder.textView.setText(datas.get(i));

        return loadview;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public  void onDataChange(List<String> list){
        this.datas=list;
        this.notifyDataSetChanged();
}
     private class ViewHolder {
        private TextView textView;
    }
}
