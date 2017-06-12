package exampleexamplem.testing.demo2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView textView=new TextView(this);
//        textView.setText("nihao");
//        textView.setTextColor(Color.BLUE);
//        textView.setTextSize(38);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        setContentView(textView);

    }
    public  void  clickButton( View view)throws JSONException{
        ImageView imageView=(ImageView)findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.second);
        eatCookie(myjson());

    }
    public void eatCookie(String message) {
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(message);

    }
    /*获取json中某key的value*/
    public  String myjson() throws JSONException {
         String json="{\"status\": {\"status\": \"SUCCESS\",\"desc\": \"get user success\"},\"code\": 0}";
        JSONObject root=new JSONObject(json);
        JSONObject staunus=root.getJSONObject("status");
        String desc=staunus.getString("desc");
        return desc;
    }
}
