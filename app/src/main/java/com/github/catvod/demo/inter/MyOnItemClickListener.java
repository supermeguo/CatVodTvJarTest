package com.github.catvod.demo.inter;

import com.github.catvod.demo.adapter.VideoBean;

import java.util.List;

public interface MyOnItemClickListener {

    void onClickItem(List<VideoBean> data, int position);
}
