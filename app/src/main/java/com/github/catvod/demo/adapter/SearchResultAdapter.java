package com.github.catvod.demo.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.SearchBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchResultAdapter extends BaseQuickAdapter<SearchBean.ListBean, BaseViewHolder> {
    public SearchResultAdapter() {
        super(R.layout.item_search);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.ListBean item) {
        ImageView ivSearchPic = helper.getView(R.id.ivSearchPic);
        TextView tvSearchName = helper.getView(R.id.tvSearchName);

        Picasso.get().load(item.getVod_pic()).into(ivSearchPic);
        tvSearchName.setText(item.getVod_name());

    }
}
