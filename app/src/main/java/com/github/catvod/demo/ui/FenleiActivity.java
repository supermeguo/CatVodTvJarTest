package com.github.catvod.demo.ui;

import static com.github.catvod.demo.R.id.*;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.catvod.demo.R;
import com.github.catvod.demo.adapter.FenleiAdapter;
import com.github.catvod.demo.adapter.HomeTabAdapter;
import com.github.catvod.demo.adapter.SortFilterAdapter;
import com.github.catvod.demo.bean.FenleiBean;
import com.github.catvod.demo.bean.FliterItemBean;
import com.github.catvod.demo.bean.SortFilter;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.github.catvod.demo.utlis.XpathInstance;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FenleiActivity extends BaseActivity {


    private FenleiAdapter fenleiAdapter;
    private List<FenleiBean.ListBean> listBeans;
    private HashMap<String, String> filterSelect = new HashMap<>();
    private HomeTabAdapter homeTabAdapter;
    private int selectPosition;
    private List<XshijueHomeListBean.ClassBean> classX;
    private String typeId;
    private String typeName;
    private XshijueHomeListBean.ClassBean classBean;

    //    private HashMap<String, SortFilterAdapter> sortAdapterMap = new HashMap<>();
    private LinearLayout linFliterLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_fenlei;
    }

    @Override
    protected void initData() {
        getCategeData();
        homeTabAdapter.setNewData(classX);
    }

    private void getCategeData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String categoryContent = XpathInstance.getInstance().categoryContent(typeId, true, filterSelect);
                Log.i("dddddd", "categoryContent = " + categoryContent);
                setNewData(categoryContent);
            }
        }).start();
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();

        selectPosition = intent.getIntExtra("position", 0);
        String homeData = intent.getStringExtra("homeData");
        linFliterLayout = findViewById(R.id.linFliterLayout);
        XshijueHomeListBean xshijueHomeListBean = new Gson().fromJson(homeData, XshijueHomeListBean.class);
        classX = xshijueHomeListBean.getClassX();
        classBean = classX.get(selectPosition);
        typeId = classBean.getType_id();
        typeName = classBean.getType_name();
        ArrayList<SortFilter> sortFilters = classBean.getFilters();
        setFliteritem(sortFilters);

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
        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCategeData();

            }
        });

        RecyclerView reHomeTab = findViewById(R.id.reHomeTab);
        homeTabAdapter = new HomeTabAdapter();
        reHomeTab.setAdapter(homeTabAdapter);
        homeTabAdapter.setSelectPosition(selectPosition);
        homeTabAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                classBean = classX.get(position);
                typeId = classBean.getType_id();
                filterSelect.clear();
                ArrayList<SortFilter> filters = classBean.getFilters();
                homeTabAdapter.setSelectPosition(position);
//                Set<String> strings = sortAdapterMap.keySet();
//                for (String key0 : strings) {
//                    SortFilterAdapter sortFilterAdapter = sortAdapterMap.get(key0);
//                    sortFilterAdapter.setFilterSelect(filterSelect);
//                }
                setFliteritem(filters);
                getCategeData();
            }
        });
    }

    private void setFliteritem(ArrayList<SortFilter> sortFilters) {
        linFliterLayout.removeAllViews();
        for (int i = 0; i < sortFilters.size(); i++) {
            SortFilter sortFilter = sortFilters.get(i);

            View inflate = getLayoutInflater().inflate(R.layout.fenlei_layout, null);
            linFliterLayout.addView(inflate);
            TextView tvFenleiTitle = inflate.findViewById(R.id.tvFliterTitle);
            tvFenleiTitle.setText(sortFilter.name);

            RecyclerView recycerItem = inflate.findViewById(R.id.recycerItem);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            recycerItem.setLayoutManager(linearLayoutManager);

            SortFilterAdapter sortFilterAdapter = new SortFilterAdapter();
            recycerItem.setAdapter(sortFilterAdapter);
            Set<String> strings = sortFilters.get(i).values.keySet();
            ArrayList<FliterItemBean> fliterItemBeans = new ArrayList<>();
            for (String key : strings) {
                FliterItemBean fliterItemBean = new FliterItemBean();
                fliterItemBean.setName(sortFilters.get(i).values.get(key));
                fliterItemBean.setValve(key);
                fliterItemBean.setCategeKey(sortFilter.getKey());
                fliterItemBean.setCategeName(sortFilter.getName());
                fliterItemBeans.add(fliterItemBean);
            }
            sortFilterAdapter.setNewData(fliterItemBeans);
            sortFilterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    ArrayList<FliterItemBean> adapterData = (ArrayList<FliterItemBean>) adapter.getData();
                    FliterItemBean fliterItemBean = adapterData.get(position);
                    String categeKey = fliterItemBean.getCategeKey();
                    String name = fliterItemBean.getName();

                    if (filterSelect.containsKey(categeKey)) {
                        filterSelect.remove(categeKey);
                    }
                    filterSelect.put(categeKey, name);
                    ((SortFilterAdapter) adapter).setFilterSelect(filterSelect);
                }
            });

        }
    }

    private void setNewData(String categoryContent) {
        FenleiBean fenleiBean = new Gson().fromJson(categoryContent, FenleiBean.class);
        listBeans = fenleiBean.getList();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fenleiAdapter.setNewData(listBeans);
            }
        });
    }

}
