package com.github.catvod.demo.bean;

import com.github.catvod.demo.adapter.VideoBean;

import java.util.ArrayList;
import java.util.List;

public class PlayBean {
    public List<VideoBean> playName = new ArrayList<>();
    public String playFromName;

    public List<VideoBean> getPlayName() {
        return playName;
    }

    public void setPlayName(List<VideoBean> playName) {
        this.playName = playName;
    }

    public String getPlayFromName() {
        return playFromName;
    }

    public void setPlayFromName(String playFromName) {
        this.playFromName = playFromName;
    }
}
