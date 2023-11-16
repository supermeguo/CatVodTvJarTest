package com.github.catvod.demo.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.XshijueHomeListBean;

import java.util.List;

public class HomeTabAdapter extends BaseQuickAdapter<XshijueHomeListBean.ClassBean, BaseViewHolder> {
    public HomeTabAdapter() {
        super(R.layout.item_home_tab);
    }

    @Override
    protected void convert(BaseViewHolder helper, XshijueHomeListBean.ClassBean item) {
        TextView tvTabName = helper.getView(R.id.tvTabName);
        tvTabName.setText(item.getType_name());
    }
}
