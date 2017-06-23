package yanxiu.com.yxyl;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mLoginNameView,mPasswordView;
    private ImageView mClearLoginNameView,mCipherPassView;
    private TextView mRegisterView,mForgetPassView;
    private Button mLoginButton;



    private static final String TAG = "杜杜杜";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG,"onCreate创建");
        initView();
        lister();
        initData();


    }
////    String loginname;
////    EditText text =(EditText) findViewById(R.id.login_name);
//
//    public EditText getText() {
//        return text;
//    }
/*初始化界面*/
     private void initView(){
         mLoginNameView=(EditText) findViewById(R.id.ed_login_name);
         mPasswordView=(EditText) findViewById(R.id.ed_login_password);
         mClearLoginNameView=(ImageView)findViewById(R.id.iv_loginname_clear);
         mCipherPassView=(ImageView)findViewById(R.id.iv_cipher_loginPassword);
         mRegisterView=(TextView) findViewById(R.id.tx_register);
         mForgetPassView=(TextView) findViewById(R.id.tx_forgetPass);
         mLoginButton=( Button)findViewById(R.id.bt_login);

     }
     private  void lister(){
         mLoginButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.i(TAG,mLoginNameView.getText().toString());//获取用户名
                 if(mLoginNameView.getText().toString().trim().length()<8||mLoginNameView.getText().toString().trim().length()>16){
                     Toast toast;
                     toast=Toast.makeText(getApplicationContext(),"输入的用户名位数不对",Toast.LENGTH_SHORT);
                     toast.show();
                 }
                 else{
                     Intent intent =new Intent(LoginActivity.this,JoinClassActivity.class);
                     if(intent.resolveActivity(getPackageManager())!=null) {
                         startActivity(intent);
                 }
                 }
             }
         });
     }
     private void initData(){
         mClearLoginNameView.setEnabled(false);
         mLoginButton.setEnabled(false);
         if(mLoginNameView.getText()!=null&&mPasswordView.getText()!=null){
             mLoginNameView.setEnabled(true);
         }
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
         Intent intent =new Intent(this,JoinClassActivity.class);
         if(intent.resolveActivity(getPackageManager())!=null) {
             startActivity(intent);
         }
     }*/
    public void forgetPass(View view){
        Intent intent =new Intent(this,ForgetPasswordActivity.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }
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
