package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JoinClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_class);
    }
    public void nextStep(View view){
            Intent intent =new Intent(this,CommitName.class);
            if(intent.resolveActivity(getPackageManager())!=null) {
                startActivity(intent);
            }

    }
}
