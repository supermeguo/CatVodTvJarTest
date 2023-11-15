package com.github.catvod.demo.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.demo.R;

import java.util.List;

public class PlayNameAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {
    public PlayNameAdapter() {
        super(R.layout.item_play_name);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBean item) {
        TextView tvPlayName = helper.getView(R.id.tvPlayName);
        tvPlayName.setText(item.getVideoName());
    }
}
