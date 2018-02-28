package du.com.listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by srt-k12001 on 2017/9/13.
 */

public class SubjectAdapt extends ArrayAdapter {
    public SubjectAdapt(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View view= LayoutInflater.from(getContext()).inflate()

        return super.getView(position, convertView, parent);
    }

}
