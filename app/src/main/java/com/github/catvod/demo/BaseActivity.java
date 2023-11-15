package com.github.catvod.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();
}
