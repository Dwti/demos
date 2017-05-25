package exampleexample.testing.justjava;

import android.icu.text.NumberFormat;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addOrder(View view){
          count=count+1;
            displayCount(count);

    }
    public void reduceOrder(View view){
        count =count-1;
        if(count<0){
            count=0;
        }
        else {
            displayCount(count);
        }

    }
    public void submitOrder(View view){
        int price=8;
        String message="hello"+calulatePrice(price)          ;
//        displayPrice(price);
        displayMessage(message);
    }

    public  void  displayCount(int number){
      TextView textView=(TextView) findViewById(R.id.count_text_view);
        textView.setText(""+number);

}

    public  void  displayPrice(int price) {
        TextView textView = (TextView) findViewById(R.id.pricecount_text_view);
//        textView.setText(NumberFormat.getCurrencyInstance().format(price));
        textView.setText(" " + count * price);
    }
    public void displayMessage(String message) {
        TextView textView = (TextView) findViewById(R.id.pricecount_text_view);

        textView.setText("" + message);

    }
    private  int calulatePrice(int price){
        int sumPrice=count*price;
        return  sumPrice;
    }
//    MediaPlayer mediaPlayer=MediaPlayer.create();
//    Toast toast=Toast.makeText();
}
