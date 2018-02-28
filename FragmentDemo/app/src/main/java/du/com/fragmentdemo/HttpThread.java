package du.com.fragmentdemo;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by srt-k12001 on 2017/8/11.
 */

public class HttpThread extends Thread {
    private String mUrl;
    private WebView mWebView;
    private Handler mHandler;//子线程更新UI
    //给构造函数添加三个参数
    public HttpThread(String url,WebView webView,Handler handler){
        this.mUrl=url;
        this.mWebView=webView;
        this.mHandler=handler;

    }

    @Override
    public void run() {
        try {
            URL httpUrl=new URL(mUrl);
            HttpURLConnection connection= (HttpURLConnection) httpUrl.openConnection();
            connection.setReadTimeout(5000);//超时
            connection.setRequestMethod("GET");
            final StringBuffer sb=new StringBuffer();//???为什么要用final修饰呢？
            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String str;
            while ((str=reader.readLine())!= null){
                sb.append(str);

            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mWebView.loadData(sb.toString()," meta charset=UTF-8",null);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
