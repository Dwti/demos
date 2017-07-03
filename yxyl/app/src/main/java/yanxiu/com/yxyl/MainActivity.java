package yanxiu.com.yxyl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
   private Button mRequest;
    private TextView mReponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lister();



    }
    private  void  initData(){
        mRequest=(Button) findViewById(R.id.request);
        mReponse=(TextView) findViewById(R.id.response);

    }

    private void lister(){
        mRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             sendRequest();
            }
        });

    }
    public void sendRequest(){
        new  Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader=null;
                try{
                    URL url=new URL("http://www.baidu.com");
                    connection=(HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    InputStream  in= connection.getInputStream();
                    //读取输入流in
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder showMessage=new StringBuilder();
                    String line;
                    while ((line = reader.readLine())!=null){
                        showMessage.append(line);

                    }
                    showData(showMessage.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if(reader!=null){
                        try {
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if(connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    //在主线程改变UI
    private void showData(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mReponse.setText(response);
            }
        });
    }
    //添加点击的方法启动登录界面
    public void  ToUse(View view){
        Intent intent=new Intent(this,LoginActivity.class);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
}
