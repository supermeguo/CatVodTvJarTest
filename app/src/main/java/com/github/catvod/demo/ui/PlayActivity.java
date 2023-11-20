package com.github.catvod.demo.ui;

import android.content.Intent;
import android.util.Log;

import com.github.catvod.demo.R;

public class PlayActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_play;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
        Log.i("dddddd", "videourl=" + videourl);
    }
}
