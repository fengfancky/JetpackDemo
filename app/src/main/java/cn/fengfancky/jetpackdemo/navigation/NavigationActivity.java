package cn.fengfancky.jetpackdemo.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import androidx.navigation.Navigation;
import cn.fengfancky.jetpackdemo.BaseActivity;
import cn.fengfancky.jetpackdemo.R;

public class NavigationActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.nav_layout);

        Intent intent = getIntent();
        setToolTitle(intent.getStringExtra("name"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.fragmentNavigation).navigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Navigation.findNavController(this, R.id.fragmentNavigation).navigateUp()||super.onOptionsItemSelected(item);
    }
}
