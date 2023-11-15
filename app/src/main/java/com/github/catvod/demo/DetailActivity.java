package com.github.catvod.demo;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.catvod.demo.adapter.PlayConfigAdapter;
import com.github.catvod.demo.adapter.VideoBean;
import com.github.catvod.demo.bean.DetailBean;
import com.github.catvod.demo.bean.PlayBean;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends BaseActivity {

    private String detailContent;
    private ImageView ivDtPic;
    private TextView tvDtLeixing;
    private TextView tvDtYear;
    private TextView tvDtAre;
    private TextView tvDtyanyuan;
    private TextView tvDtDaoyan;
    private TextView tvDtDec;
    private RecyclerView rePlayFrom;
    private PlayConfigAdapter playConfigAdapter;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        detailContent = intent.getStringExtra("detailContent");
        DetailBean detailBean = new Gson().fromJson(detailContent, DetailBean.class);
        List<DetailBean.ListBean> list = detailBean.getList();
        if (list == null || list.size() == 0) {
            return;
        }
        DetailBean.ListBean listBean = list.get(0);
        Picasso.get().load(listBean.getVod_pic()).into(ivDtPic);
        tvDtLeixing.setText("类型：" + listBean.getVod_name());
        tvDtYear.setText("年份：" + listBean.getVod_year());
        tvDtAre.setText("地区：" + listBean.getVod_area());
        tvDtyanyuan.setText("演员：" + listBean.getVod_actor());
        tvDtDaoyan.setText("导演：" + listBean.getVod_director());
        tvDtDec.setText("剧情介绍：" + listBean.getVod_content());
        String vodPlayFrom = listBean.getVod_play_from();
        String[] fromList = vodPlayFrom.split("\\$\\$\\$");
        ArrayList<PlayBean> fromListData = new ArrayList<>();
        for (String s : fromList) {
            PlayBean playBean = new PlayBean();
            playBean.setPlayFromName(s);
            fromListData.add(playBean);
        }
        String vodPlayUrl = listBean.getVod_play_url();
        String[] playParentName = vodPlayUrl.split("\\$\\$\\$");
        for (int i = 0; i < playParentName.length; i++) {
            String s = playParentName[i];
            String[] episodeplit = s.split("#");
            PlayBean playBean = fromListData.get(i);
            List<VideoBean> playName = playBean.getPlayName();
            for (String s1 : episodeplit) {
                String[] $s = s1.split("\\$");
                VideoBean videoBean = new VideoBean();
                videoBean.setVideoName($s[0]);
                videoBean.setVideoId($s[1]);
                playName.add(videoBean);
            }

            playBean.setPlayName(playName);
        }
        playConfigAdapter.setNewData(fromListData);
    }

    @Override
    protected void initView() {
        ivDtPic = findViewById(R.id.ivDtPic);
        tvDtLeixing = findViewById(R.id.tvDtLeixing);
        tvDtYear = findViewById(R.id.tvDtYear);
        tvDtAre = findViewById(R.id.tvDtAre);
        tvDtyanyuan = findViewById(R.id.tvDtyanyuan);
        tvDtDaoyan = findViewById(R.id.tvDtDaoyan);
        tvDtDec = findViewById(R.id.tvDtDec);
        rePlayFrom = findViewById(R.id.rePlayFrom);
        playConfigAdapter = new PlayConfigAdapter();
        rePlayFrom.setAdapter(playConfigAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_detail;
    }
}
