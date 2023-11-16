package com.github.catvod.demo.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.catvod.demo.R;
import com.github.catvod.demo.adapter.FenleiAdapter;
import com.github.catvod.demo.adapter.HomeGameListAdapter;
import com.github.catvod.demo.bean.FenleiBean;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.github.catvod.demo.utlis.XpathInstance;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FenleiActivity extends BaseActivity {

    private String typeId;
    private String typeName;
    private FenleiAdapter fenleiAdapter;
    private List<FenleiBean.ListBean> listBeans;

    @Override
    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HashMap<String, String> filterSelect = new HashMap<>();

                String categoryContent = XpathInstance.getInstance().getXpath().categoryContent(typeId, "1", true, filterSelect);
                FenleiBean fenleiBean = new Gson().fromJson(categoryContent, FenleiBean.class);
                listBeans = fenleiBean.getList();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fenleiAdapter.setNewData(listBeans);
                    }
                });

            }
        }).start();

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        typeId = intent.getStringExtra("typeId");
        typeName = intent.getStringExtra("typeName");
        String filters = intent.getStringExtra("filters");
        XshijueHomeListBean.FiltersBean filtersBean = new Gson().fromJson(filters, XshijueHomeListBean.FiltersBean.class);


        ((TextView) findViewById(R.id.tvFenleiTitle)).setText(typeName);
        RecyclerView reHomeList = findViewById(R.id.reHomeList);
        fenleiAdapter = new FenleiAdapter();
        reHomeList.setAdapter(fenleiAdapter);

        fenleiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                FenleiBean.ListBean listBean = listBeans.get(position);
                String vodId = listBean.getVod_id();

                List<String> idList = new ArrayList<>();
                idList.add(vodId);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String detailContent = XpathInstance.getInstance().detailContent(idList);
                        if (TextUtils.isEmpty(detailContent)) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, "暂无相关资源", Toast.LENGTH_SHORT).show();
                                }
                            });

                            return;
                        }
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("detailContent", detailContent);
                        startActivity(intent);
                    }
                }).start();

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_fenlei;
    }
}
