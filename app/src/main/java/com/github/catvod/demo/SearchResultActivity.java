package com.github.catvod.demo;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.github.catvod.demo.adapter.SearchResultAdapter;
import com.github.catvod.demo.bean.SearchBean;
import com.google.gson.Gson;

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
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }
}
