package cn.fengfancky.jetpackdemo.behavior;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/22.
 */

public class ResultActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.reustl_layout);
        setToolTitle("Notification Result");
    }
}
