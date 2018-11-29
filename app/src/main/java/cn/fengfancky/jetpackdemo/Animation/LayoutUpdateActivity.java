package cn.fengfancky.jetpackdemo.Animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;
import cn.fengfancky.jetpackdemo.view.FixedGridLayout;

/**
 * Created by office on 2018/11/22.
 */

public class LayoutUpdateActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.update_layout);
        setToolTitle(getIntent().getStringExtra("name"));
        final ViewGroup viewGroup = findViewById(R.id.container1);

//        final FixedGridLayout fixedGridLayout = new FixedGridLayout(this);
//        fixedGridLayout.setCellHeight(180);
//        fixedGridLayout.setCellWidth(260);
//        viewGroup.addView(fixedGridLayout);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button button = new Button(LayoutUpdateActivity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(10,10,10,10);
                button.setText("button");
                viewGroup.addView(button,viewGroup.getChildCount());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewGroup.removeView(v);
                    }
                });
            }
        });
    }
}
