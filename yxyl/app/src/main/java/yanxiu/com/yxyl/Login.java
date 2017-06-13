package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    String loginname;
    EditText text =(EditText) findViewById(R.id.login_name);

    public EditText getText() {
        return text;
    }

    public void ForgetPass(View view){
        Intent intent =new Intent(this,ForgetPassword.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
    public void Register(View view) {
        Intent intent = new Intent(this, Register.class);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }
}
