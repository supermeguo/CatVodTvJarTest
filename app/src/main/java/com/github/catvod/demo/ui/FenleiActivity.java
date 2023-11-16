package com.github.catvod.demo.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.catvod.demo.R;
import com.github.catvod.demo.adapter.HomeGameListAdapter;
import com.github.catvod.demo.utlis.XpathInstance;

import java.util.HashMap;

public class FenleiActivity extends BaseActivity {

    private String typeId;
    private String typeName;

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HashMap<String, String> filterSelect = new HashMap<>();

                String categoryContent = XpathInstance.getInstance().getXpath().categoryContent(typeId, "1", false, filterSelect);
                Log.i("dddddd", "categoryContent=" + categoryContent);
            }
        }).start();

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        typeId = intent.getStringExtra("typeId");
        typeName = intent.getStringExtra("typeName");

        ((TextView) findViewById(R.id.tvFenleiTitle)).setText(typeName);
        RecyclerView reHomeList = findViewById(R.id.reHomeList);
        reHomeList.setAdapter(new HomeGameListAdapter());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_fenlei;
    }
}
