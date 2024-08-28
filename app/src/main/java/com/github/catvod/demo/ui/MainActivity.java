package com.github.catvod.demo.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.catvod.demo.R;
import com.github.catvod.demo.adapter.HomeGameListAdapter;
import com.github.catvod.demo.adapter.HomeTabAdapter;
import com.github.catvod.demo.bean.SearchBean;
import com.github.catvod.demo.bean.SortFilter;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.github.catvod.demo.utlis.JsonUtils;
import com.github.catvod.demo.utlis.XpathInstance;
import com.github.catvod.loader.JarLoader;
import com.github.catvod.spider.XPathFilter;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    JarLoader jarLoader = new JarLoader();
    private TextView tvSearchFun;
    private EditText etInputSearch;
    private List<XshijueHomeListBean.ListBean> homeListBeanList;
    private HomeGameListAdapter homeGameListAdapter;
    private HomeTabAdapter homeTabAdapter;
    private List<XshijueHomeListBean.ClassBean> classX = new ArrayList<>();
    private XshijueHomeListBean xshijueHomeListBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        try {
//            InputStream is = getAssets().open("custom_spider.jar");
//            int len = is.available();
//            byte[] data = new byte[len];
//            is.read(data);
//            is.close();
//            jarLoader.load(this, data);
//            https://www.80yy3.com/vplay/151899-1-1.html
//            https://www.80yy3.com/vplay//vplay/151899-1-2.html
            new Thread(new Runnable() {
                @Override
                public void run() {
                    XPathFilter xPathFilter = new XPathFilter();
                    XpathInstance.getInstance().setxpath(xPathFilter);
                    String assetsJson = JsonUtils.getAssetsJson(MainActivity.this, "feitucr.json");
                    XpathInstance.getInstance().init(mContext, assetsJson);
                    String homeContent = XpathInstance.getInstance().homeContent(true);

                    String videoContent = XpathInstance.getInstance().homeVideoContent();
                    Log.i("dddddd", "homeContent=" + homeContent);
                    xshijueHomeListBean = new Gson().fromJson(homeContent, XshijueHomeListBean.class);
                    xshijueHomeListBean = JsonUtils.getFilters(xshijueHomeListBean, homeContent);
                    if (xshijueHomeListBean != null) {
                        homeListBeanList = xshijueHomeListBean.getList();
                        if (homeListBeanList == null || homeListBeanList.size() == 0) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, "获取首页数据失败", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        classX.addAll(xshijueHomeListBean.getClassX());
                        XshijueHomeListBean.ClassBean classBean = new XshijueHomeListBean.ClassBean();
                        classBean.setType_name("首页");
                        classBean.setType_id("-1");
                        classX.add(0, classBean);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                homeGameListAdapter.setNewData(homeListBeanList);
                                homeTabAdapter.setNewData(classX);
                            }
                        });
                    }


                }
            }).start();
        } catch (Exception e) {
            Log.i("dddddd", "e= " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {
        initSearch();
        RecyclerView reHomeList = findViewById(R.id.reHomeList);
        RecyclerView reHomeTab = findViewById(R.id.reHomeTab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        reHomeTab.setLayoutManager(linearLayoutManager);

        homeTabAdapter = new HomeTabAdapter();
        reHomeTab.setAdapter(homeTabAdapter);

        homeTabAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 0) {
                    return;
                }
                String toJson = new Gson().toJson(xshijueHomeListBean);
                Intent intent = new Intent(mContext, FenleiActivity.class);
                intent.putExtra("position", position - 1);
                intent.putExtra("homeData", toJson);
                startActivity(intent);
            }
        });

        homeGameListAdapter = new HomeGameListAdapter();
        reHomeList.setAdapter(homeGameListAdapter);
        homeGameListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                XshijueHomeListBean.ListBean listBean = homeListBeanList.get(position);
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

    private void initSearch() {
        tvSearchFun = findViewById(R.id.tvSearchFun);
        etInputSearch = findViewById(R.id.etInputSearch);
        tvSearchFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inPutName = etInputSearch.getText().toString().trim();
                if (TextUtils.isEmpty(inPutName)) {
                    Toast.makeText(mContext, "请输入名称后搜索", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String searchContent = XpathInstance.getInstance().searchContent(inPutName, false);
                        SearchBean searchBean = new Gson().fromJson(searchContent, SearchBean.class);
                        if (searchBean==null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, "搜索结果为空", Toast.LENGTH_SHORT).show();
                                }
                            });
                            return;
                        }
                        List<SearchBean.ListBean> list = searchBean.getList();
                        if (TextUtils.isEmpty(searchContent) || list.isEmpty()) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(mContext, "搜索结果为空", Toast.LENGTH_SHORT).show();
                                }
                            });
                            return;
                        }
                        Intent intent = new Intent(mContext, SearchResultActivity.class);
                        intent.putExtra("resultJson", searchContent);
                        startActivity(intent);
                        Log.i("dddddd", "searchContent=" + searchContent);
                    }
                }).start();

            }
        });
    }

}