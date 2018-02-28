package du.com.httpdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
     private  WebView webView;
     private Handler handler=new Handler();


    //请求登录界面的 数据、
    private TextView mobile,passworld;
    private Button login,dopost,doPostFile,doPostImage,download;
    private  TextView showResponse;
    private String url;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         /*webView= (WebView) findViewById(R.id.baidu);*/
         initview();
//         new HttpThread("",webView,handler).start();
         listener();

    }

        private  void  initview(){

            mobile= (TextView) findViewById(R.id.et_moblie);
            passworld= (TextView) findViewById(R.id.et_password);
            login= (Button) findViewById(R.id.login_bt);
            showResponse= (TextView) findViewById(R.id.t_show);
            dopost= (Button) findViewById(R.id.bt_doPost);
            doPostFile= (Button) findViewById(R.id.bt_doFile);
            doPostImage= (Button) findViewById(R.id.bt_doImage);
            download= (Button) findViewById(R.id.bt_download);
            image= (ImageView) findViewById(R.id.im_image);


        }


        private  void listener(){
            /*http://localhost:8080/du_yanxiu/login?mobile=111&password=2344*/
//            url="http://test.hwk.yanxiu.com/app/user/login.do?mobile="+mobile.getText()+"&"+"password="+passworld.getText();

//            url="http://192.168.2.166:8080/du_okhttp/login?mobile=12233&password=33333";
            login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                   /* new HttpLogin("http://dev.hwk.yanxiu.com/app/user/login.do",mobile.getText().toString(),passworld.getText().toString()).start*//*();*/
                    try {
                        url="http://192.168.2.166:8080/du_okhttp/login?mobile="+mobile.getText().toString()+"&"+"password="+passworld.getText().toString();
                        new MyokHttp(url,login,showResponse).doGet();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            dopost.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    url = "http://test.hwk.yanxiu.com/app/user/login.do";
                    new MyokHttp(url,login,showResponse).doPost();

                }

            });
            //提交文件
            doPostFile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url = "http://192.168.2.166:8080/du_okhttp/login";
                    new MyokHttp(url,login,showResponse).doPostFile();

                }
            });
            doPostImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url = "http://192.168.2.166:8080/du_okhttp/login";
                    new MyokHttp(url,login,showResponse).doPostImage();
                }
            });

            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url = "http://wx4.sinaimg.cn/woriginal/7f96be87ly1fjfdi9i21yj20jg0okn52.jpg";
                    new MyokHttp(url,login,showResponse).downLoadImage(image);
                }
            });
        }
}
