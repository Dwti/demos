package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CommitNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_name);
        Button button=(Button) findViewById(R.id.bt_commit_button);
        ImageView backJoinclass=(ImageView)findViewById(R.id.iv_backJoinclass);
        backJoinclass.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }

        });


    }

    public void joinBasepage(View view){
        Intent intent=new Intent(this,BasepageActivity.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    @Override
    protected void onStop() {

        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
    }


}
