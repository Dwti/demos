package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private ImageView mBack,mClearMoblie;
    private EditText mMoblie;
    private EditText mCode;
    private TextView mGetCode;
    private EditText mPassWord;
    private CheckBox mPassWordCipher;
    private Button mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        lister();
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
        //暂时未实现功能
      mGetCode.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

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
                if(mMoblie.getText().toString().trim().length()<11){
                   toast=Toast.makeText(getApplicationContext(),"手机号位数不对", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(mCode.getText().toString().trim().length()<4){
                    toast=Toast.makeText(getApplicationContext(),"验证码不能少于4位", Toast.LENGTH_SHORT);
                    toast.show();
                }else if( mPassWord.getText().toString().trim().length()<6){
                    toast=Toast.makeText(getApplicationContext(),"密码位数不对", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Intent intent=new Intent(RegisterActivity.this,CommitNameActivity.class);
                    if(intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);

                    }
                }
            }
        });
    }

}
