package du.com.httpdemo;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by srt-k12001 on 2017/9/5.
 */
import java.net.URL;

public class HttpThread extends Thread {
    private String murl;
    private Handler mhandler;
    private WebView mwebView;
    public HttpThread(String url,WebView webView,Handler handler){
        this.murl=url;
        this.mwebView=webView;
        this.mhandler=handler;

    }

    @Override
    public void run() {
        super.run();
        try {
            URL httpUrl=new URL(murl);
            HttpURLConnection connection= (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("GET");//设置请求方式
            connection.setReadTimeout(5000);//请求超时时间
            final StringBuffer stringBuffer=new StringBuffer();//
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (bufferedReader.readLine()!=null){
                stringBuffer.append(bufferedReader.readLine());
            }
            //开启线程处理UI
            mhandler.post(new Runnable() {
                @Override
                public void run() {
                    mwebView.loadData(stringBuffer.toString(),"text/html charset=utf-8",null);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
