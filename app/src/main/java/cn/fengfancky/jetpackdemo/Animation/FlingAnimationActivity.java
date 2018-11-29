package cn.fengfancky.jetpackdemo.Animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/21.
 */

public class FlingAnimationActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.fling_layout);

        Intent intent = getIntent();
        setToolTitle(intent.getStringExtra("name"));

        Button button = findViewById(R.id.button);
        final View ball = findViewById(R.id.ball);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 *setStartVelocity() 设置初速度
                 *setFriction() 设置摩擦系数，默认为1。决定动画变慢的速度
                 */
                FlingAnimation fling = new FlingAnimation(ball, DynamicAnimation.X);
                fling.setStartVelocity(2000f)
                        .setFriction(1f);
                fling.start();
            }
        });

    }


}
