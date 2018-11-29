package cn.fengfancky.jetpackdemo.Animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/23.
 */

public class PaletteActivity extends BaseActivity {

    ImageView bg;
    private Drawable startDrawable;
    View view1,view2,view3,view4,view5,view6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.palette_layout);
        setToolTitle("Palette");
        startDrawable = getResources().getDrawable(R.drawable.palette_bg);

        bg = findViewById(R.id.bg);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);
        view6 = findViewById(R.id.view6);

        findViewById(R.id.img1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPaletteToBackground(R.mipmap.img1);
            }
        });

        findViewById(R.id.img2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPaletteToBackground(R.mipmap.img2);
            }
        });
    }

    private void getPaletteToBackground(int imgId){
        Glide.with(this)
                .load(imgId)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {

                                int mutedColor = palette.getMutedColor(Color.TRANSPARENT);
                                int darkMutedColor = palette.getDarkMutedColor(Color.TRANSPARENT);
                                int lightMutedColor = palette.getLightMutedColor(Color.TRANSPARENT);
                                int vibrantColor = palette.getVibrantColor(Color.TRANSPARENT);
                                int darkVibrantColor = palette.getDarkVibrantColor(Color.TRANSPARENT);
                                int lightVibrantColor = palette.getLightVibrantColor(Color.TRANSPARENT);

                                view1.setBackgroundColor(mutedColor);
                                view2.setBackgroundColor(darkMutedColor);
                                view3.setBackgroundColor(lightMutedColor);
                                view4.setBackgroundColor(vibrantColor);
                                view5.setBackgroundColor(darkVibrantColor);
                                view6.setBackgroundColor(lightVibrantColor);

//                                int[] colors = new int[]{mutedColor,darkMutedColor,lightMutedColor,vibrantColor,darkVibrantColor,lightVibrantColor};

                                if(palette==null)
                                    return;
                                try{

                                    int colorOne,colorTwo;
                                    colorOne = palette.getVibrantColor(Color.TRANSPARENT);

                                    colorTwo = palette.getMutedColor(Color.TRANSPARENT);
                                    if (colorOne== Color.TRANSPARENT){
                                        colorOne = palette.getVibrantColor(Color.TRANSPARENT);
                                    }

                                    if (colorTwo == Color.TRANSPARENT){
                                        colorTwo = palette.getMutedColor(Color.TRANSPARENT);
                                    }
                                    createLinearGradientBitmap(colorOne ,colorTwo );

                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                            }
                        });

                    }
                });
    }

    //创建线性渐变背景色
    private void createLinearGradientBitmap(int darkColor,int color) {
        int bgColors[] = new int[2];
        bgColors[0] = darkColor;
        bgColors[1] = color;

        Bitmap  bgBitmap= Bitmap.createBitmap(bg.getWidth(),bg.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas();
        Paint paint=new Paint();
        canvas.setBitmap(bgBitmap);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LinearGradient gradient=new LinearGradient(0, 0, 0, bgBitmap.getHeight(),bgColors[0],bgColors[1], Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        paint.setAntiAlias(true);
        RectF rectF=new RectF(0,0,bgBitmap.getWidth(),bgBitmap.getHeight());
        canvas.drawRoundRect(rectF,20,20,paint);
        canvas.drawRect(rectF,paint);

        Drawable drawable = new BitmapDrawable(getResources(),bgBitmap);
        if (startDrawable == drawable){
            return;
        }
        Drawable[] drawableArray = {startDrawable, drawable};
        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArray);
        bg.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(800);
        startDrawable = drawable;

    }

}
