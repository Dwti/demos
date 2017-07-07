package yanxiu.com.yxyl;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private ImageView mBack,mClearMoblie;
    private EditText mMoblie;
    private EditText mCode;
    private TextView mGetCode;
    private EditText mPassWord;
    private CheckBox mPassWordCipher;
    private Button mRegister;
    private boolean runtime;//^(13[0-9]|15[0-9]|17[0-9]|18[0-9])d{8}$
    private String mPattern="^(13[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$";//^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$

    private static final String TAG = "测试测试测试测测试测测";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        lister();
    }
    //正则匹配一下
     public  Matcher match(){
         Pattern pattern;
         Matcher matcher;
         pattern=Pattern.compile(mPattern);
         matcher=pattern.matcher(mMoblie.getText().toString().trim());
         return  matcher;
     }
    private  void initView(){
        mBack=(ImageView )findViewById(R.id.iv_back);
        mClearMoblie=(ImageView )findViewById(R.id.iv_clear_moblienumber);
        mMoblie=(EditText)findViewById(R.id.ed_moblie_number);
        mCode=(EditText)findViewById(R.id.ed_verfication_number);
        mGetCode=(TextView)findViewById(R.id.tx_getCodenumber);
        mPassWord=(EditText)findViewById(R.id.ed_password);
        mPassWordCipher=( CheckBox)findViewById(R.id.ck_cipher);
        mRegister=( Button)findViewById(R.id.bt_register);
    }
 class RegisterTextWatch implements TextWatcher{
     @Override
     public void beforeTextChanged(CharSequence s, int start, int count, int after) {

     }

     @Override
     public void onTextChanged(CharSequence s, int start, int before, int count) {
         if(mMoblie.length()>0){
             mClearMoblie.setVisibility(View.VISIBLE);
             mGetCode.setEnabled(true);

         }else {
             mClearMoblie.setVisibility(View.INVISIBLE);
             mGetCode.setEnabled(false);
         }
     }
     @Override
     public void afterTextChanged(Editable s) {
          if(mMoblie.length()>0&&mCode.length()>0&&mPassWord.length()>0){
              mRegister.setEnabled(true);
          }else {
              mRegister.setEnabled(false);
          }
     }
 }
    private  void clickAble(){
        RegisterTextWatch textWatch=new RegisterTextWatch();
        mMoblie.addTextChangedListener(textWatch);
        mCode.addTextChangedListener(textWatch);
        mPassWord.addTextChangedListener(textWatch);
    }
    private  void  lister(){
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       mClearMoblie.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mMoblie.setText(null);
           }
       });
        //暂时未实现功能matcher.find()


        mGetCode.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {
              Log.d(TAG,match().toString());
            /*  mMoblie.getText().toString().trim().substring(0,1).equals("1")*/
              if(match().find()) {
                  CountDownTimer downTimer=new CountDownTimer(45*1000,1000) {
                      @Override
                      public void onTick(long millisUntilFinished) {
                          runtime=true;
                          mGetCode.setText((millisUntilFinished/1000)+"s");
                          mGetCode.isEnabled();//在倒计时中"获取验证码不可再点击"
                      }

                      @Override
                      public void onFinish() {
                          runtime=false;
                          mGetCode.setText("重新获取");

                      }
                  };
                  if(runtime){
                  }else{
                      downTimer.start();
                  }

              }
              else{
                  Toast toast;
                  toast=Toast.makeText(getApplicationContext(),"请输入正确手机号", Toast.LENGTH_SHORT);
                  toast.show();

              }


          }
      });


        mPassWordCipher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPassWordCipher.isChecked()){
                    mPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    mPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        clickAble();
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast toast;
                if(mMoblie.getText().toString().trim().length()<11||!match().find()){
                   toast=Toast.makeText(getApplicationContext(),"请输入正确手机号", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(mCode.getText().toString().trim().length()<4){
                    toast=Toast.makeText(getApplicationContext(),"验证码不能少于4位", Toast.LENGTH_SHORT);
                    toast.show();
                }else if( mPassWord.getText().toString().trim().length()<6){
                    toast=Toast.makeText(getApplicationContext(),"密码位数不对", Toast.LENGTH_SHORT);
                    toast.show();

                }
                else {
                    Intent intent=new Intent(RegisterActivity.this,JoinClassActivity.class);
                    if(intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);

                    }
                }
            }
        });
    }

}
