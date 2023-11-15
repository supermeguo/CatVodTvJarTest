package com.github.catvod.demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.catvod.crawler.Spider;
import com.github.catvod.demo.R;
import com.github.catvod.demo.bean.PlayBean;
import com.github.catvod.demo.utlis.XpathInstance;

import java.util.ArrayList;
import java.util.List;

public class PlayConfigAdapter extends BaseQuickAdapter<PlayBean, BaseViewHolder> {
    public PlayConfigAdapter() {
        super(R.layout.item_play_config);
    }

    @Override
    protected void convert(BaseViewHolder helper, PlayBean item) {
        TextView tvPlayFromName = helper.getView(R.id.tvPlayFromName);
        Context mContext = tvPlayFromName.getContext();
        String playFromName = item.getPlayFromName();
        tvPlayFromName.setText(playFromName);
        RecyclerView rePlayNameList = helper.getView(R.id.rePlayNameList);
        PlayNameAdapter playNameAdapter = new PlayNameAdapter();
        rePlayNameList.setAdapter(playNameAdapter);
        playNameAdapter.setNewData(item.getPlayName());
        playNameAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<VideoBean> data = adapter.getData();
                VideoBean videoBean = data.get(position);
                String videoId = videoBean.getVideoId();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String playerContent = XpathInstance.getInstance().playerContent("guozi", videoId, new ArrayList<>());
                        tvPlayFromName.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mContext, "playerContent=" + playerContent, Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }).start();
            }
        });
    }
}
