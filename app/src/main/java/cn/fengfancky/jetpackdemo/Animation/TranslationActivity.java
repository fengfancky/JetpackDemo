package cn.fengfancky.jetpackdemo.Animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/22.
 */

public class TranslationActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.translation_layout);
        setToolTitle(getIntent().getStringExtra("name"));
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            TranslationFragment fragment = new TranslationFragment();
            transaction.replace(R.id.frame, fragment);
            transaction.commit();
        }
    }



}
