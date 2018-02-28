package response;

import android.util.Log;

import com.dutt.network.HttpCallback;
import com.dutt.network.RequestBase;

import java.util.logging.Logger;

/**
 * Created by srt-k12001 on 2017/12/19.
 */

public class HomeWorkCallback<T> implements HttpCallback<T> {
    @Override
    public void onSuccess(RequestBase request, Object ret) {
        Log.e("请求接口","请求成功");


    }


    @Override
       public void onFail(RequestBase request, Error error) {
        Log.e("error","杜婷婷请求失败");




    }
}
