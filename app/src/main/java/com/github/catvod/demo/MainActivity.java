package com.github.catvod.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.github.catvod.crawler.Spider;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.github.catvod.loader.JarLoader;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    JarLoader jarLoader = new JarLoader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            InputStream is = getAssets().open("custom_spider.jar");
            int len = is.available();
            byte[] data = new byte[len];
            is.read(data);
            is.close();
            jarLoader.load(this, data);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Spider xpath = jarLoader.getSpider("XPathFilter");
                    String assetsJson = JsonUtils.getAssetsJson(MainActivity.this, "xshijue.json");

                    xpath.init(MainActivity.this, assetsJson);
                    String homeContent = xpath.homeContent(true);
                    String videoContent = xpath.homeVideoContent();
                    Log.i("dddddd", "homeContent=" + homeContent);
                    XshijueHomeListBean xshijueHomeListBean = new Gson().fromJson(homeContent, XshijueHomeListBean.class);
                    List<XshijueHomeListBean.ListBean> homeListBeanList = xshijueHomeListBean.getList();
                    if (homeListBeanList.size() > 0) {
                        XshijueHomeListBean.ListBean listBean = homeListBeanList.get(0);
                        String vodId = listBean.getVod_id();
                        List<String> idList = new ArrayList<>();
                        idList.add(vodId);
                        String detailContent = xpath.detailContent(idList);
                        Log.i("dddddd", "detailContent=" + detailContent);
                    }


//                    System.out.println();
//                    System.out.println(xpath.homeVideoContent());
//                    List<String> ids = new ArrayList<>();
//                    ids.add("44703");
//                    System.out.println(xpath.detailContent(ids));
//                    System.out.println(xpath.playerContent("1号线路", "44703-0-0", new ArrayList<>()));
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}