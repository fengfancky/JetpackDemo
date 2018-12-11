package cn.fengfancky.jetpackdemo.navigation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.navigation.ActivityNavigator;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import cn.fengfancky.jetpackdemo.R;

public class RecommendFragment extends Fragment {
    ImageView one,two;
    Button button2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.recommend_layout,container,false);
        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        button2 = view.findViewById(R.id.button2);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("img",R.mipmap.img1);
                bundle.putString("title","使至塞上");
                bundle.putString("des","单车欲问边，属国过居延。\n 征蓬出汉塞，归雁入胡天。\n大漠孤烟直，长河落日圆。\n萧关逢候骑，都护在燕然。");

//                FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
//                        .addSharedElement(one, one.getTransitionName())
//                        .build();

                Navigation.findNavController(v).navigate(R.id.action_recommendFragment_to_detailsFragment,bundle);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("img",R.mipmap.img2);
                bundle.putString("title","塞下曲六首");
                bundle.putString("des","五月天山雪，无花只有寒。\n" +
                        "笛中闻折柳，春色未曾看。\n" +
                        "晓战随金鼓，宵眠抱玉鞍。\n" +
                        "愿将腰下剑，直为斩楼兰。");
                Navigation.findNavController(v).navigate(R.id.action_recommendFragment_to_detailsFragment,bundle);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_recommendFragment_to_aboutFragment);
            }
        });

        return view;
    }
}
