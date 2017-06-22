package yanxiu.com.yxyl;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    private static final String TAG = "杜杜杜";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG,"onCreate创建");

        Button loginButton=(Button) findViewById(R.id.bt_login);
        final EditText loginName=(EditText) findViewById(R.id.ed_login_name);
        final EditText loginPass=(EditText) findViewById(R.id.ed_login_password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG,loginName.getText().toString());

                if(loginName.getText().toString().trim().length()<=8){
                    Toast toast;
                    toast=Toast.makeText(getApplicationContext(),"hhhh",Toast.LENGTH_SHORT);
                    toast.show();
                }
                Intent intent =new Intent(LoginActivity.this,JoinClassActivity.class);
                if(intent.resolveActivity(getPackageManager())!=null) {
                    startActivity(intent);
                }
            }
        });

    }
////    String loginname;
////    EditText text =(EditText) findViewById(R.id.login_name);
//
//    public EditText getText() {
//        return text;
//    }

     private void initView(View v){

  }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart启动");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart再次启动");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume处于焦点");


    }

    /*public  void loginSuccess(View view){
         Intent intent =new Intent(this,JoinClass.class);
         if(intent.resolveActivity(getPackageManager())!=null) {
             startActivity(intent);
         }
     }
    public void forgetPass(View view){
        Intent intent =new Intent(this,ForgetPassword.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
    public void register(View view) {
        Intent intent = new Intent(this, Register.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }*/
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause活动状态，暂停");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop停止，失去焦点");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy销毁，被回收");
    }
}
