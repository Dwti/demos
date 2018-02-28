package du.com.httpdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;

/**
 * 1.拿到OkHttpClient对象
 * 2.构造request
 *   2.1构造requestBody
 *   2.2包装requestBody
 *  3.Call->execute
 */

public class MyokHttp extends AppCompatActivity {
    private String murl;
    private Button bt;
    private TextView mshowResult;
    private  OkHttpClient client=new OkHttpClient();
    MyokHttp(String url ,Button bt,TextView mshowResult){
        this.murl=url;
        this.bt=bt;
        this.mshowResult=mshowResult;

    }

    void doGet() throws IOException {
        //1.拿到OkHttpClient对象

        //2.创建一个请求
        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url(murl).build();
        execureRequest(request);//执行request


    }

    void doPost() {
        //OkHttp3.x，FormEncodingBuilder已被FormBody取代）
//        FormEncodingBuilder formEcodingBuilder=new FormEncodingBuilder();
        FormBody body=new FormBody.Builder()
                .add("mobile","18612345600")
                .add("password","666666")
                .add("deviceId","09817c28c0284a59b5cbc810dbe05bf3")
                .add("osType",	"1")
                .add("version","3.0")
                .build();
        //创建RequestBody对象
        //创建一个请求
        Request.Builder builder=new Request.Builder();
        Request request=builder
                              .post(body)
                              .url(murl)
                              .build();
        execureRequest(request);

     }
    /*提交文件*/
    void doPostFile(){
//        //mine type
//       File  file=new File(Environment.getExternalStorageDirectory(),"111.png");
//        if(!file.exists()) {
//            Log.e(file.getAbsolutePath(), "is not exists");
//            return;//一定要return
//        }
        RequestBody body =RequestBody.create(MediaType.parse("text/plain;charset=utf-8"),"{mobile:1200000,password:12345566}");
        Request.Builder builder=new Request.Builder();

        Request request=builder.url(murl).post(body).build();
        execureRequest(request);
    }
    void doPostImage(){
        //mine type
       File  file=new File(Environment.getExternalStorageDirectory(),"share_logo.png");
        if(!file.exists()) {
            Log.e(file.getAbsolutePath(), "is not exists");
            return;//一定要return
        }
        RequestBody body =RequestBody.create(MediaType.parse("text/plain;charset=utf-8"),file);
        Request.Builder builder=new Request.Builder();

        Request request=builder.url(murl).post(body).build();

    }

    void downLoad() {
        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url(murl).build();

        Call call = client.newCall(request);
        //4.执行call
        /*Response response;
        response=call.execute();//同步执行*/
        //异步执行
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("出错了dopost", e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                InputStream input = response.body().byteStream();
                int len = 0;
                File file = new File(Environment.getExternalStorageDirectory(), "888.jpg");
                byte[] buf = new byte[128];
                FileOutputStream fo = new FileOutputStream(file);
                while ((len = input.read(buf)) != -1) {
                    fo.write(buf, 0, len);



                }
                fo.flush();
                fo.close();
                input.close();
            }

            });

        }
    void downLoadImage(final ImageView image) {
        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url(murl).build();

        Call call = client.newCall(request);
        //4.执行call
        /*Response response;
        response=call.execute();//同步执行*/
        //异步执行
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("出错了dopost", e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                /*long total=response.body().contentLength();
                long sum=0L;*/
                InputStream input = response.body().byteStream();
                /* BitmapFactory.Options;*/
                final Bitmap bitmap=BitmapFactory.decodeStream(input);
//
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageBitmap(bitmap);

                    }
                });
            }

        });

    }



            private void execureRequest(Request request) {

                //3.把request 包装成call
                Call call = client.newCall(request);
                //4.执行call
        /*Response response;
        response=call.execute();//同步执行*/
                //异步执行
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("出错了dopost", e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        Log.e("success", "");
                        final String str = response.body().string();
              /*  InputStream inputStream = response.body().byteStream();*/
                        Log.e("sucess", str);
                        //extends AppCompatActivity 才能更新UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mshowResult.setText(str);
                            }
                        });
                    }
                });
            }
}










