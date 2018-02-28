package du.com.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by srt-k12001 on 2017/8/9.
 */

public class TitleFragment extends Fragment {
   private ImageButton button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.title_fragment,container,false);
        button= (ImageButton) view.findViewById(R.id.title_im_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"哈哈哈哈哈",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
