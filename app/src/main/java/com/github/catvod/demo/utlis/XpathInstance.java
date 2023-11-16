package com.github.catvod.demo.utlis;

import android.content.Context;

import com.github.catvod.crawler.Spider;

import java.util.List;

public class XpathInstance {

    private final static XpathInstance mXpathInstance = new XpathInstance();


    public static Spider xpath;

    public XpathInstance() {

    }

    public static XpathInstance getInstance() {
        return mXpathInstance;
    }

    public void setxpath(Spider xpath) {
        this.xpath = xpath;
    }

    public  Spider getXpath() {
        return xpath;
    }


    public String searchContent(String inPutName, boolean isQuick) {
        String searchContent = xpath.searchContent(inPutName, isQuick);
        return searchContent;
    }

    public String homeContent(boolean filter) {
        return xpath.homeContent(filter);
    }

    public String homeVideoContent() {
        return xpath.homeVideoContent();
    }

    public String detailContent(List<String> idList) {
        return xpath.detailContent(idList);
    }

    public void init(Context mContext, String assetsJson) {
        xpath.init(mContext,assetsJson);
    }

    public String playerContent(String guozi, String videoId, List<String> objects) {
        return   xpath.playerContent(guozi,videoId,objects);
    }
}
