package du.com.httpdemo;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import okhttp3.OkHttpClient;


/**
 * Created by srt-k12001 on 2017/9/6.
 */

public class HttpLogin extends Thread {

    String url,mobile,password,deviceId,osType,version;
    private  TextView textView;


    public HttpLogin( String url,String mobile,String password){
        this.url=url;
        this.mobile=mobile;
        this.password=password;

    }
    private  void doGet() throws UnsupportedEncodingException {
        url=url+"?moblie="+URLEncoder.encode(mobile,"utf-8")+"&password="+password;//汉语转码

        try {
            URL loginUrl=new URL(url);
            HttpURLConnection connection= (HttpURLConnection) loginUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer=new StringBuffer();//存放bufferedReader读取的数据流
            String str;

            while((str=bufferedReader.readLine())!=null){
                  buffer.append(str);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        super.run();
        try {
            doGet();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
