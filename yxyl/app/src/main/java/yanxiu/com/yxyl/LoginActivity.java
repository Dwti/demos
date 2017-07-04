package yanxiu.com.yxyl;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Throwable;


public class LoginActivity extends AppCompatActivity {
    private LinearLayout mLayout;
    private EditText mLoginNameView, mPasswordView;
    private ImageView mClearLoginNameView;
    private CheckBox mCipherPassView;
    private TextView mRegisterView, mForgetPassView;
    private Button mLoginButton;
    private boolean isEmpty;
    private  boolean hasChanged;
    private boolean hasCipher=false;


    private static final String TAG = "杜杜杜";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "onCreate创建"+isEmpty);
        initView();
        lister();
//        initData();



    }

    ////    String loginname;
////    EditText text =(EditText) findViewById(R.id.login_name);
//
//    public EditText getText() {
//        return text;
//    }
/*初始化界面*/
    private void initView() {
        mLayout=(LinearLayout) findViewById(R.id.layout);
        mLoginNameView = (EditText) findViewById(R.id.ed_login_name);
        mPasswordView = (EditText) findViewById(R.id.ed_login_password);
        mClearLoginNameView = (ImageView) findViewById(R.id.iv_loginname_clear);
        mCipherPassView = (CheckBox) findViewById(R.id.iv_cipher_loginPassword);
        mRegisterView = (TextView) findViewById(R.id.tx_register);
        mForgetPassView = (TextView) findViewById(R.id.tx_forgetPass);
        mLoginButton = (Button) findViewById(R.id.bt_login);


    }
    //自定义监听器
    class MyTextWatch implements TextWatcher{
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          if(mLoginNameView.length()>0){
              mClearLoginNameView.setVisibility(View.VISIBLE);
          }
          else{
              mClearLoginNameView.setVisibility(View.INVISIBLE);
          }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(mLoginNameView.length()>0&&mPasswordView.length()>0){
                mLoginButton.setEnabled(true);
            }else {
                mLoginButton.setEnabled(false);
            }

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
    }
    private void hasChanged() {
        MyTextWatch myTextWatch=new MyTextWatch();
        mLoginNameView.addTextChangedListener(myTextWatch);
        mPasswordView.addTextChangedListener(myTextWatch);
    }
    private void lister() {
        hasChanged();
        mClearLoginNameView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mLoginNameView.setText(null);
            }
        });
        mCipherPassView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCipherPassView.isChecked()){
//                    mPasswordView.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
                    mPasswordView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }else {
//                   mPasswordView.setInputType(EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mPasswordView.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, mLoginNameView.getText().toString());//获取用户名
                Toast toast;
//                mLoginButton.setBackgroundColor(getResources().getColor(R.color.colorButtonOClick));
                //已经限制了输入位数最多是16位，此处不需要判断大于16位
                if (mLoginNameView.getText().toString().trim().length() < 11) {

                    toast = Toast.makeText(getApplicationContext(), "输入的用户名位数不对", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (mPasswordView.getText().toString().trim().length() < 6) {
                    toast = Toast.makeText(getApplicationContext(), "密码位数不对", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, JoinClassActivity.class);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
            }
        });
    }



    private void initData() {
        mClearLoginNameView.setEnabled(false);
        mClearLoginNameView.setVisibility(View.INVISIBLE);
        mLoginButton.setEnabled(false);


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart启动");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart再次启动");
    }

    @Override
    protected void onResume() {
        super.onResume();


        Log.i(TAG, "onResume处于焦点"+mPasswordView.hasFocus());


    }

    /*public  void loginSuccess(View view){
         Intent intent =new Intent(this,JoinClassActivity.class);
         if(intent.resolveActivity(getPackageManager())!=null) {
             startActivity(intent);
         }
     }*/
    public void forgetPass(View view) {
        Intent intent = new Intent(this, ForgetPasswordActivity.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
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
        Log.i(TAG, "onPause活动状态，暂停");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop停止，失去焦点");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy销毁，被回收");
    }
}

