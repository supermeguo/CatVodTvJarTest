package com.github.catvod.demo.adapter;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.XshijueHomeListBean;

import java.util.List;

public class HomeTabAdapter extends BaseQuickAdapter<XshijueHomeListBean.ClassBean, BaseViewHolder> {
    private int selectPosition;

    public HomeTabAdapter() {
        super(R.layout.item_home_tab);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void convert(BaseViewHolder helper, XshijueHomeListBean.ClassBean item) {
        TextView tvTabName = helper.getView(R.id.tvTabName);
        Context context = tvTabName.getContext();
        if (helper.getLayoutPosition()==selectPosition) {
            tvTabName.setTextColor(context.getColor(R.color.color_0CADE2));

        }else {
            tvTabName.setTextColor(context.getColor(R.color.color_CC000000));
        }
        tvTabName.setText(item.getType_name());
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();
    }
}
