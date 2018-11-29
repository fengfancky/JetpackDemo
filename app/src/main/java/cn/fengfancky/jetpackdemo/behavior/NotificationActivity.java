package cn.fengfancky.jetpackdemo.behavior;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

/**
 * Created by office on 2018/11/22.
 */

public class NotificationActivity extends BaseActivity {

    NotificationManager  manager;
    Notification notification;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.notification_layout);
        setToolTitle(getIntent().getStringExtra("name"));
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //Android8.0
                    NotificationChannel mChannel = new NotificationChannel("100", "My notification", NotificationManager.IMPORTANCE_LOW);
                    mNotificationManager.createNotificationChannel(mChannel);

                    Notification.Builder  mBuilder = new Notification.Builder(NotificationActivity.this)
                            .setChannelId("100")
                            .setContentTitle("My notification")
                            .setContentText("Hello World!")
                            .setSmallIcon(R.mipmap.ic_launcher);



                    Intent resultIntent = new Intent(NotificationActivity.this, ResultActivity.class);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotificationActivity.this);
                    stackBuilder.addParentStack(ResultActivity.class);
                    stackBuilder.addNextIntent(resultIntent);
                    PendingIntent resultPendingIntent =
                            stackBuilder.getPendingIntent(
                                    0,
                                    PendingIntent.FLAG_UPDATE_CURRENT
                            );
                    mBuilder.setContentIntent(resultPendingIntent);
                    notification = mBuilder.build();

                }else {
                    NotificationCompat.Builder mBuilder =
                            new NotificationCompat.Builder(NotificationActivity.this)
                                    .setSmallIcon(R.mipmap.ic_launcher)
                                    .setContentTitle("My notification")
                                    .setContentText("Hello World!");

                    Intent resultIntent = new Intent(NotificationActivity.this, ResultActivity.class);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotificationActivity.this);
                    stackBuilder.addParentStack(ResultActivity.class);
                    stackBuilder.addNextIntent(resultIntent);
                    PendingIntent resultPendingIntent =
                            stackBuilder.getPendingIntent(
                                    0,
                                    PendingIntent.FLAG_UPDATE_CURRENT
                            );
                    mBuilder.setContentIntent(resultPendingIntent);
                    notification = mBuilder.build();

                }

                    RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification);

                    final String time = DateFormat.getTimeInstance().format(new Date()).toString();
                    final String text = "当前时间："+time;
                    contentView.setTextViewText(R.id.textView, text);
                    notification.contentView = contentView;

                    if (Build.VERSION.SDK_INT >= 16) {
                        RemoteViews expandedView =
                                new RemoteViews(getPackageName(), R.layout.notification_expanded);
                        notification.bigContentView = expandedView;
                    }
                mNotificationManager.notify(100, notification);


            }
        });
    }
}
