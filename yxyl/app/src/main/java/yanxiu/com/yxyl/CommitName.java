package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CommitName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_name);
    }
    public void joinBasepage(View view){
        Intent intent=new Intent(this,Basepage.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
}
