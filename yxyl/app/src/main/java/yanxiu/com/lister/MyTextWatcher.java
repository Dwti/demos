package yanxiu.com.lister;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by srt-k12001 on 2017/7/3.
 */

public class MyTextWatcher implements TextWatcher{
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.length()>0){

        }
    }
}
