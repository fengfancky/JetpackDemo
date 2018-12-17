package cn.fengfancky.jetpackdemo.navigation

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.Navigation
import cn.fengfancky.jetpackdemo.BaseActivity
import cn.fengfancky.jetpackdemo.R

class NavigationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView(R.layout.nav_layout)

        val intent = intent
        setToolTitle(intent.getStringExtra("name"))

    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragmentNavigation).navigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return Navigation.findNavController(this, R.id.fragmentNavigation).navigateUp() || super.onOptionsItemSelected(item)
    }
}
