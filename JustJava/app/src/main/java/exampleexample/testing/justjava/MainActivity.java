package exampleexample.testing.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.icu.text.StringPrepParseException;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

    }
    /*调用系统相机*/
  /*  public void  clickPhoto(View view){
        Intent intent=new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if(intent.resolveActivity(getPackageManager())!=null){
         startActivity(intent);
        }
    }*/
    public void addOrder(View view){
        if(count>=100)
        {
            count=100;
//            Toast.makeText(this,"最多添加100杯",Toast.LENGTH_SHORT).show();
            createToast("最多添加100杯");
        }else{
            count=count+1;
            displayCount(count);
        }

    }
    public void reduceOrder(View view){
        count =count-1;
        if(count<1){
            count=1;
//            Toast.makeText(this,"至少添加1杯",Toast.LENGTH_SHORT).show();
            createToast("至少添加1杯");
        }
        else {
            displayCount(count);
        }

    }

    public void submitOrder(View view){
        CheckBox checkBoxMilk=(CheckBox) findViewById(R.id.checkbox_milk);
        CheckBox checkBoxChocolate=(CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean hasChenckedMilk= checkBoxMilk.isChecked();
        boolean hasChenckedChoncolate = checkBoxChocolate.isChecked();
        int price=8;

        if(hasChenckedChoncolate&&!hasChenckedMilk){
           sendMessage("order details 1",displayMessage(1,8,hasChenckedMilk,hasChenckedChoncolate));
        }
        else if(hasChenckedMilk&&!hasChenckedChoncolate){
            sendMessage("order details 2",displayMessage(2,8,hasChenckedMilk,hasChenckedChoncolate));
            displayMessage(2,8,hasChenckedMilk,hasChenckedChoncolate);
        }
        else if (hasChenckedChoncolate&&hasChenckedMilk){
            sendMessage("order details 3",displayMessage(3,8,hasChenckedMilk,hasChenckedChoncolate));
            displayMessage(3,8,hasChenckedMilk,hasChenckedChoncolate);
        }else {
            sendMessage("order details 4",displayMessage(0,8,hasChenckedMilk,hasChenckedChoncolate));
            displayMessage(0,8,hasChenckedMilk,hasChenckedChoncolate);
        }
        String message="hello"+calulatePrice(price)          ;
//        displayPrice(price);

//        displayMessage(0,8,hasChenckedMilk,hasChenckedChoncolate);
        Log.v("MainActivity","是否被选中："+hasChenckedMilk);
        Log.v("MainActivity","单价是："+price);
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
/*    public void displayMessage(int otherprice,int price,boolean hasCheckedMilk,boolean hasCheckedChocolate) {
        TextView textView = (TextView) findViewById(R.id.pricecount_text_view);
        EditText editTextNamde=(EditText) findViewById(R.id.edit_name);

           Object sumMessage= "name:"+editTextNamde.getText();
        sumMessage+="\nchenck:"+hasCheckedMilk;
        sumMessage+="\nchenck:"+hasCheckedChocolate;
        sumMessage+="\ncount:"+count;
        sumMessage+="\n单价："+price;
        sumMessage+="\ntotal:"+(count*price+otherprice);
        sumMessage+="\nxiexie!!";
        textView.setText("" + sumMessage);


    }*/
    public String  displayMessage(int otherprice,int price,boolean hasCheckedMilk,boolean hasCheckedChocolate) {
        TextView textView = (TextView) findViewById(R.id.pricecount_text_view);
        EditText editTextName = (EditText) findViewById(R.id.edit_name);
        String sumMessage = "name:" + editTextName.getText().toString();
        sumMessage += "\nchenck:" + hasCheckedMilk;
        sumMessage += "\nchenck:" + hasCheckedChocolate;
        sumMessage += "\ncount:" + count;
        sumMessage += "\n单价：" + price;
        sumMessage += "\ntotal:" + (count * price + otherprice);
        sumMessage += "\nxiexie!!";
        textView.setText("" + sumMessage);
    return sumMessage;
    }




    private  int calulatePrice(int price){
        int sumPrice=count*price;
        return  sumPrice;
    }
//    MediaPlayer mediaPlayer=MediaPlayer.create();
//    Toast toast=Toast.makeText();
    /*toast提示函数*/
    public  void createToast(String toastmeassage){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_container));
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText(toastmeassage);
        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }
    public void sendMessage( String subject,String sendMessage){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,sendMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
