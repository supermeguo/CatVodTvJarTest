package com.github.catvod.demo.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeGameListAdapter extends BaseQuickAdapter<XshijueHomeListBean.ListBean, BaseViewHolder> {
    public HomeGameListAdapter() {
        super(R.layout.item_home_game);
    }

    @Override
    protected void convert(BaseViewHolder helper, XshijueHomeListBean.ListBean item) {
        ImageView ivSearchPic = helper.getView(R.id.ivHomePic);
        TextView tvSearchName = helper.getView(R.id.tvHomeName);

        Picasso.get().load(item.getVod_pic()).into(ivSearchPic);
        tvSearchName.setText(item.getVod_name());
    }
}
