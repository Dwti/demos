package du.com.fragmentdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {
    private WebView webView;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView= (WebView) findViewById(R.id.web_view);
        new HttpThread("https://www.yixueyilian.com",webView,handler).start();

    }
}
