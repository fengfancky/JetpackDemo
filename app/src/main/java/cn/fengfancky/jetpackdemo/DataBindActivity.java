package cn.fengfancky.jetpackdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import cn.fengfancky.jetpackdemo.bean.BindData;
import cn.fengfancky.jetpackdemo.databinding.DatabindActivityBinding;


public class DataBindActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabindActivityBinding databindActivityBinding = DataBindingUtil.setContentView(this,R.layout.databind_activity);
        final BindData bindData = new BindData("fengfancky","cn cbg math qdu",true);
        databindActivityBinding.setBinddata(bindData);

        databindActivityBinding.nameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DataBindActivity.this, bindData.getName()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
