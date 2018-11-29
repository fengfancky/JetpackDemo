package cn.fengfancky.jetpackdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by office on 2018/11/21.
 */

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FrameLayout content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);

        toolbar = findViewById(R.id.toolbar);
        content = findViewById(R.id.content);

    }

    public void setToolTitle(String str){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    public void setView(int layoutResId){
        View view = LayoutInflater.from(this).inflate(layoutResId,null);
        content.addView(view);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
