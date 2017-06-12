package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    //添加点击的方法启动登录界面
    public void  ToUse(View view){
        Intent intent=new Intent(this,Login.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
}
