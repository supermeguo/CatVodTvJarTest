package com.github.catvod.demo;

import android.app.Activity;
import android.os.Bundle;

import com.github.catvod.crawler.Spider;
import com.github.catvod.loader.JarLoader;

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
                    xpath.init(MainActivity.this, "{\n" +
                            "    \"ua\": \"Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1\",\n" +
                            "    \"homeUrl\": \"https://saohuo.vip\",\n" +
                            "    \"cateNode\": \"//ul[contains(@class,'type_list')]/li/a[contains(@href, '.html')]\",\n" +
                            "    \"cateName\": \"/text()\",\n" +
                            "    \"cateId\": \"/@href\",\n" +
                            "    \"cateIdR\": \"/list/(\\\\d+).html\",\n" +
                            "    \"cateManual\": {\n" +
                            "        \n" +
                            "    },\n" +
                            "    \"homeVodNode\": \"//ul[@class='v_list']/li/div[@class='v_img']\",\n" +
                            "    \"homeVodName\": \"/a/@title\",\n" +
                            "    \"homeVodId\": \"/a/@href\",\n" +
                            "    \"homeVodIdR\": \"/movie/(\\\\w+).html\",\n" +
                            "    \"homeVodImg\": \"/a/img/@data-original\",\n" +
                            "    \"homeVodMark\": \"/div[@class='v_note']/text()\",\n" +
                            "    \"cateUrl\": \"https://saohuo.vip/list/{cateId}-{catePg}.html\",\n" +
                            "    \"cateVodNode\": \"//ul[@class='v_list']/li/div[@class='v_img']\",\n" +
                            "    \"cateVodName\": \"/a/@title\",\n" +
                            "    \"cateVodId\": \"/a/@href\",\n" +
                            "    \"cateVodIdR\": \"/movie/(\\\\w+).html\",\n" +
                            "    \"cateVodImg\": \"/a/img/@data-original\",\n" +
                            "    \"cateVodMark\": \"/div[@class='v_note']/text()\",\n" +
                            "    \"dtUrl\": \"http://saohuo.vip/movie/{vid}.html\",\n" +
                            "    \"dtNode\": \"//body\",\n" +
                            "    \"dtName\": \"//section[contains(@class,'v_info_box')]/h1[1]/text()\",\n" +
                            "    \"dtImg\": \"//section[contains(@class,'v_info')]/div[@class='m_background']/@style\",\n" +
                            "    \"dtImgR\": \"background-image:url\\\\((\\\\S+)\\\\)\",\n" +
                            "    \"dtCate\": \"//section[contains(@class,'v_info_box')]/p[1]/text()\",\n" +
                            "    \"dtDesc\": \"//p[contains(@class,'show_part')]/text()\",\n" +
                            "    \"dtFromNode\": \"//ul[@class='from_list']/li\",\n" +
                            "    \"dtFromName\": \"/text()\",\n" +
                            "    \"dtUrlNode\": \"//ul[@class='play_list' or @class='large_list']/li\",\n" +
                            "    \"dtUrlSubNode\": \"/a\",\n" +
                            "    \"dtUrlId\": \"@href\",\n" +
                            "    \"dtUrlIdR\": \"/play/(\\\\S+).html\",\n" +
                            "    \"dtUrlName\": \"/text()\",\n" +
                            "    \"playUrl\": \"http://saohuo.vip/play/{playUrl}.html\",\n" +
                            "    \"searchUrl\": \"https://saohuo.vip/search.php?searchword={wd}\",\n" +
                            "    \"scVodNode\": \"//ul[@class='v_list']/li/div[@class='v_img']\",\n" +
                            "    \"scVodName\": \"/a/@title\",\n" +
                            "    \"scVodId\": \"/a/@href\",\n" +
                            "    \"scVodIdR\": \"/movie/(\\\\w+).html\",\n" +
                            "    \"scVodImg\": \"/a/img/@data-original\",\n" +
                            "    \"scVodMark\": \"/div[@class='v_note']/text()\"\n" +
                            "}");

                    System.out.println(xpath.homeContent(true));
                    System.out.println(xpath.homeVideoContent());
                    List<String> ids = new ArrayList<>();
                    ids.add("44703");
                    System.out.println(xpath.detailContent(ids));
                    System.out.println(xpath.playerContent("1号线路", "44703-0-0", new ArrayList<>()));
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}