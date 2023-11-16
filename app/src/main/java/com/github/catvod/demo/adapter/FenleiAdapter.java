package com.github.catvod.demo.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.FenleiBean;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.squareup.picasso.Picasso;

public class FenleiAdapter extends BaseQuickAdapter<FenleiBean.ListBean, BaseViewHolder> {
    public FenleiAdapter() {
        super(R.layout.item_home_game);
    }

    @Override
    protected void convert(BaseViewHolder helper, FenleiBean.ListBean item) {
        ImageView ivSearchPic = helper.getView(R.id.ivHomePic);
        TextView tvSearchName = helper.getView(R.id.tvHomeName);

        Picasso.get().load(item.getVod_pic()).into(ivSearchPic);
        tvSearchName.setText(item.getVod_name());
    }
}