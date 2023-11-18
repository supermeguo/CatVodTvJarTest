package com.github.catvod.demo.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.FliterItemBean;
import com.github.catvod.demo.bean.SortFilter;

import java.util.LinkedHashMap;
import java.util.List;

public class SortFilterAdapter extends BaseQuickAdapter<FliterItemBean, BaseViewHolder> {
    public SortFilterAdapter() {
        super(R.layout.item_fenlei_fliters);
    }

    @Override
    protected void convert(BaseViewHolder helper, FliterItemBean item) {
        TextView tvFlitersName = helper.getView(R.id.tvFlitersName);
        tvFlitersName.setText(item.getValve());
    }
}
