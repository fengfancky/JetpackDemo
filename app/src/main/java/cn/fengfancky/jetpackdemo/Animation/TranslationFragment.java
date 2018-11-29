package cn.fengfancky.jetpackdemo.Animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/14.
 */

public class TranslationFragment extends Fragment implements View.OnClickListener{

    FrameLayout root;
    private Scene mScene1,mScene2,mScene3;
    private Button button1,button2,button3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = LayoutInflater.from(getActivity()).inflate(R.layout.trans_fragment,container,false);

        root = view.findViewById(R.id.root);
        button1 = view.findViewById(R.id.step_1);
        button2 = view.findViewById(R.id.step_2);
        button3 =view.findViewById(R.id.step_3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

//        mScene1 = Scene.getSceneForLayout(root, R.layout.layout_one, getActivity());
        mScene1 = new Scene(root, root.findViewById(R.id.container));
        mScene2 = Scene.getSceneForLayout(root, R.layout.layout_two, getActivity());
        mScene3 = Scene.getSceneForLayout(root, R.layout.layout_three, getActivity());
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.step_1:
                TransitionManager.go(mScene1);
                break;
            case R.id.step_2:
                TransitionManager.go(mScene2);
                break;
            case R.id.step_3:
                TransitionManager.go(mScene3);
                break;
        }
    }
}
