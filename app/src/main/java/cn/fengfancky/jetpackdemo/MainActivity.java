package cn.fengfancky.jetpackdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.fengfancky.jetpackdemo.Animation.FlingAnimationActivity;
import cn.fengfancky.jetpackdemo.Animation.LayoutUpdateActivity;
import cn.fengfancky.jetpackdemo.Animation.PaletteActivity;
import cn.fengfancky.jetpackdemo.Animation.SpringAnimationActivity;
import cn.fengfancky.jetpackdemo.Animation.TranslationActivity;
import cn.fengfancky.jetpackdemo.Animation.ZoomActivity;
import cn.fengfancky.jetpackdemo.behavior.NotificationActivity;
import cn.fengfancky.jetpackdemo.behavior.ShareActionActivity;
import cn.fengfancky.jetpackdemo.navigation.NavigationActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<Map<String,String>> mapList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("JetpackDemo");
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);

        listView = findViewById(R.id.recycler);

        initData();

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,mapList,R.layout.item_layout,new String[]{"name"},new int[]{R.id.text});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
    }

    private void initData(){
        mapList = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("name","Share action");

        Map<String,String> map1 = new HashMap<>();
        map1.put("name","Fling Animation");

        Map<String,String> map2 = new HashMap<>();
        map2.put("name","Spring Animation");

        Map<String,String> map3 = new HashMap<>();
        map3.put("name","Translation Animation");

        Map<String,String> map4 = new HashMap<>();
        map4.put("name","Zoom Animation");

        Map<String,String> map5 = new HashMap<>();
        map5.put("name","Auto animate layout updates");

        Map<String,String> map6 = new HashMap<>();
        map6.put("name","Notification");

        Map<String,String> map7 = new HashMap<>();
        map7.put("name","Palette");

        Map<String,String> map8 = new HashMap<>();
        map8.put("name","Navigation");

        Map<String,String> map9 = new HashMap<>();
        map9.put("name","Data Binding Library");


        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        mapList.add(map5);
        mapList.add(map);
        mapList.add(map6);
        mapList.add(map7);
        mapList.add(map8);
        mapList.add(map9);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent ;
        switch (mapList.get(position).get("name")){
            case "Share action":
                intent = new Intent(this, ShareActionActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Fling Animation":
                intent = new Intent(this, FlingAnimationActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Spring Animation":
                intent = new Intent(this, SpringAnimationActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Translation Animation":
                intent = new Intent(this, TranslationActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Zoom Animation":
                intent = new Intent(this, ZoomActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Auto animate layout updates":
                intent = new Intent(this, LayoutUpdateActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Notification":
                intent = new Intent(this, NotificationActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Palette":
                intent = new Intent(this, PaletteActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
            case "Navigation":
                intent = new Intent(this, NavigationActivity.class);
                intent.putExtra("name", mapList.get(position).get("name"));
                startActivity(intent);
                break;
                case "Data Binding Library":
                intent = new Intent(this, DataBindActivity.class);
                startActivity(intent);
                break;
        }
    }
}
