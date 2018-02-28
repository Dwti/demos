package du.com.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup group;

    private Button mWeiChat,mQq,mWeibo,mBaidu;
    private ContextFragment weixin;
    private TitleFragment qq;
    private WeiboFragment weibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inintData();
        setDefaultFragment();


    }
    private  void  inintData(){
        mWeiChat= (Button) findViewById(R.id.bt_weixin);
        mQq= (Button) findViewById(R.id.bt_QQ);
        mWeibo= (Button) findViewById(R.id.bt_weibo);
        mBaidu= (Button) findViewById(R.id.bt_baidu);
        mWeiChat.setOnClickListener(this);
        mQq.setOnClickListener(this);
        mWeibo.setOnClickListener(this);
        mBaidu.setOnClickListener(this);
    }
    //动态设置默认的Fragment
   private void setDefaultFragment(){
       //实例化一个FragmentManager
       FragmentManager fragmentManager=getFragmentManager();
       //开启一个事务
       FragmentTransaction transaction=fragmentManager.beginTransaction();
       weixin=new ContextFragment();
       transaction.replace(R.id.my_context,weixin);
       transaction.commit();



   }
    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getFragmentManager();
        //开启一个事务
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case  R.id.bt_weixin:
               /* if(weixin==null){
                    weixin=new ContextFragment();
                }
                transaction.add(R.id.my_context,weixin,"hhhh");*/
               transaction.hide(weixin);

            case R.id .bt_QQ:
                if (qq== null) {
                    qq=new TitleFragment();
                }
                transaction.replace(R.id.my_context,qq);
                break;
            case R.id.bt_weibo:
                if(weibo==null){
                    weibo=new WeiboFragment();
                }
                transaction.replace(R.id.my_context,weibo);
                break;
            case R.id.bt_baidu:
                Intent intent=new Intent(this,Main2Activity.class);
                startActivity(intent);

        }

     transaction.commit();
    }
}
