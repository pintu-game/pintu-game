package com.example.renkai.login_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.renkai.login_test.R;
import com.example.renkai.login_test.pintu.PintuActivity;

public class SecondActivity extends AppCompatActivity {

    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, BlankFragment.newInstance("今日"));
//        mFragmentSparseArray.append(R.id.record_tab, BlankFragment.newInstance("记录"));
//        mFragmentSparseArray.append(R.id.contact_tab, BlankFragment.newInstance("通讯录"));
//        mFragmentSparseArray.append(R.id.settings_tab, BlankFragment.newInstance("设置"));
//        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        mFragmentSparseArray.get(checkedId)).commit();
//            }
//        });
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();
        findViewById(R.id.sign_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, PintuActivity.class));
            }
        });
        findViewById(R.id.contact_tab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, DownloadActivity.class));
            }
        });
        findViewById(R.id.settings_tab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, UsersInfo_activity.class));
            }
        });
        findViewById(R.id.record_tab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, RangeActivity.class));
            }
        });
    }
}
