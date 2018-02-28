package du.com.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bean.HomeworkDetailBean;
import request.HomeworkRequest;
import response.HomeWorkResponse;

/**
 * Created by sunpeng on 2018/1/30.
 */

public class ListViewAdapter extends BaseAdapter {
    public List<HomeworkDetailBean> datas=new ArrayList<HomeworkDetailBean>();
    public LayoutInflater inflater;

    public ListViewAdapter(List<HomeworkDetailBean> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View view=null;
         ViewHolder holder=null;
         if(convertView==null){
             view=inflater.inflate(R.layout.homework_item,null);
             holder=new ViewHolder();
             holder.homeworkImage=(ImageView)view.findViewById(R.id.im_homework);
             holder.homeworkName= (TextView) view.findViewById(R.id.tx_homeworkName);
             holder.completeNum= (TextView) view.findViewById(R.id.tx_completeNum);
             holder.homeworkDeadline= (TextView) view.findViewById(R.id.tx_homeworkDeadline);
             holder.techerComment= (TextView) view.findViewById(R.id.tx_techerComment);

             view.setTag(holder);
         }
         else {
             view=convertView;
             holder= (ViewHolder) view.getTag();
         }

            //传入数据
             holder.homeworkImage.setImageResource(R.drawable.homework3x);
             holder.homeworkName.setText(datas.get(position).getName());
             holder.completeNum.setText("完成题量"+datas.get(position).getVolume()+"/"+datas.get(position).getQuesnum());
             holder.homeworkDeadline.setText(datas.get(position).getOverTime());
             holder.techerComment.setText("没有");


        return view;
    }
  /*  SubjectAdapt s=new SubjectAdapt(this,R.layout.homework_item);
    String[] from=new String[]{"homeworkImage","homeworkName","completeNum","homeworkDeadline","techerComment"};
    int[] to=new int[]{R.id.im_homework,R.id.tx_homeworkName,R.id.tx_completeNum,R.id.tx_homeworkDeadline,R.id.tx_techerComment};*/
    private class ViewHolder {
        ImageView homeworkImage;
        TextView homeworkName,completeNum,homeworkDeadline,techerComment;

    }
    //强制动态刷新数据进而调用getView方法
    public void undateView(List<HomeworkDetailBean> nowdatas){
        this.datas=nowdatas;
        this.notifyDataSetChanged();//强制动态刷新数据进而调用getView方法

    }

}
