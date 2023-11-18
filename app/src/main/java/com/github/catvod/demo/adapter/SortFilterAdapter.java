package com.github.catvod.demo.adapter;

import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.FliterItemBean;

import java.util.HashMap;

public class SortFilterAdapter extends BaseQuickAdapter<FliterItemBean, BaseViewHolder> {
    private HashMap<String, String> filterSelect = new HashMap<>();

    public SortFilterAdapter() {
        super(R.layout.item_fenlei_fliters);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void convert(BaseViewHolder helper, FliterItemBean item) {
        TextView tvFlitersName = helper.getView(R.id.tvFlitersName);
        tvFlitersName.setText(item.getValve());
        if (filterSelect.containsValue(item.getName())) {
            tvFlitersName.setTextColor(tvFlitersName.getContext().getColor(R.color.color_96a2d7));

        } else {
            tvFlitersName.setTextColor(tvFlitersName.getContext().getColor(R.color.color_66000000));
        }
    }

    public void setFilterSelect(HashMap<String, String> filterSelect) {
        this.filterSelect = filterSelect;
        notifyDataSetChanged();
    }
}
