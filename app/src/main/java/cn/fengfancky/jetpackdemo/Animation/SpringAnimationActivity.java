package cn.fengfancky.jetpackdemo.Animation;


import android.os.Bundle;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/21.
 */

public class SpringAnimationActivity extends BaseActivity {

    boolean scale = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.spring_layout);

        setToolTitle(getIntent().getStringExtra("name"));
        final ImageView imageView = findViewById(R.id.image);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!scale){
                    final SpringAnimation animX = new SpringAnimation(imageView, SpringAnimation.SCALE_X, 1.5f);
                    final SpringAnimation animY = new SpringAnimation(imageView, SpringAnimation.SCALE_Y, 1.5f);

                    animX.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
                    animX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

                    animY.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
                    animY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                    animX.start();
                    animY.start();
                    scale = true;
                }else {
                    final SpringAnimation animX = new SpringAnimation(imageView, SpringAnimation.SCALE_X, 1f);
                    final SpringAnimation animY = new SpringAnimation(imageView, SpringAnimation.SCALE_Y, 1f);

                    animX.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
                    animX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

                    animY.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
                    animY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                    animX.start();
                    animY.start();
                    scale = false;
                }
            }
        });

    }
}
