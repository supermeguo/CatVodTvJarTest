package com.github.catvod.demo.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.catvod.demo.R;
import com.github.catvod.demo.adapter.SearchResultAdapter;
import com.github.catvod.demo.bean.FenleiBean;
import com.github.catvod.demo.bean.SearchBean;
import com.github.catvod.demo.utlis.XpathInstance;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends BaseActivity {

    private List<SearchBean.ListBean> searchList;
    private RecyclerView reSearchList;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String resultJson = intent.getStringExtra("resultJson");
        SearchBean searchBean = new Gson().fromJson(resultJson, SearchBean.class);
        searchList = searchBean.getList();

        reSearchList = findViewById(R.id.reSearchList);
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter();
        reSearchList.setAdapter(searchResultAdapter);
        searchResultAdapter.setNewData(searchList);
        searchResultAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SearchBean.ListBean listBean = searchList.get(position);
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
        return R.layout.activity_search;
    }
}
