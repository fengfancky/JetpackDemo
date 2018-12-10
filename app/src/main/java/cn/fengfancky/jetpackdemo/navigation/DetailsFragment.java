package cn.fengfancky.jetpackdemo.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import cn.fengfancky.jetpackdemo.R;

public class DetailsFragment extends Fragment {

    ImageView imageView;
    TextView textView2,textView3;
    Button but;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.details_layout,container,false);
        imageView = view.findViewById(R.id.imageView2);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);
        but = view.findViewById(R.id.but);
        final Bundle arguments = getArguments();

        imageView.setImageResource(arguments.getInt("img"));
        textView2.setText(arguments.getString("title"));
        textView3.setText(arguments.getString("des"));

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url","https://www.baidu.com/s?wd="+arguments.getString("title"));
                Navigation.findNavController(v).navigate(R.id.action_detailsFragment_to_moreFragment,bundle);
            }
        });
        return view;
    }
}
