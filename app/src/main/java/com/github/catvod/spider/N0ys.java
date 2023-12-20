package com.github.catvod.spider;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.demo.utlis.okhttp.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 90影视
 * <p>
 * Author: 小黄瓜
 */
public class N0ys extends Spider {
    private static final String siteUrl = "http://1090ys8.com";
    private static final String siteHost = "1090ys8.com";
    private static final String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36";

    /**
     * 播放源配置
     */
    private JSONObject playerConfig;

    private Pattern regexCategory = Pattern.compile("/whole/(\\w+).html");
    private Pattern regexVid = Pattern.compile("/show/(\\w+).html");
    private Pattern regexPlay = Pattern.compile("/play/(\\w+)-(\\d+)-(\\d+).html");
    private Pattern regexPage = Pattern.compile("/whole/\\d+/page/(\\d+).html");

    @Override
    public void init(Context context) {
        super.init(context);
        try {
            playerConfig = new JSONObject("{\"youbo\":{\"sh\":\"高速1\",\"sn\":\"0\",\"pu\":\"http://jx1090ys5.hongfanedu.top/x2.php?id=\",\"or\":999},\"wanpan\":{\"sh\":\"高速备用\",\"sn\":\"0\",\"pu\":\"\",\"or\":999},\"niuxyun\":{\"sh\":\"高速2\",\"sn\":\"1\",\"pu\":\"http://1090ys2.com/nxjx/jx.php?id=\",\"or\":999},\"bjm3u8\":{\"sh\":\"备用2\",\"sn\":\"0\",\"pu\":\"\",\"or\":999},\"dbm3u8\":{\"sh\":\"备用3\",\"sn\":\"0\",\"pu\":\"\",\"or\":999},\"nfmp4\":{\"sh\":\"高速3\",\"sn\":\"0\",\"pu\":\"\",\"or\":999},\"tkm3u8\":{\"sh\":\"备用1\",\"sn\":\"0\",\"pu\":\"\",\"or\":999},\"wjm3u8\":{\"sh\":\"备用4\",\"sn\":\"0\",\"pu\":\"\",\"or\":999}}");
        } catch (JSONException e) {
            SpiderDebug.log(e);
        }
    }

    /**
     * 爬虫headers
     *
     * @param url
     * @return
     */
    protected HashMap<String, String> getHeaders(String url) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("method", "GET");
        headers.put("Host", siteHost);
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("DNT", "1");
        headers.put("User-Agent", ua);
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        return headers;
    }

    /**
     * 获取分类数据 + 首页最近更新视频列表数据
     *
     * @param filter 是否开启筛选 关联的是 软件设置中 首页数据源里的筛选开关
     * @return
     */
    @Override
    public String homeContent(boolean filter) {
        try {
            Document doc = Jsoup.parse(OkHttpUtil.string(siteUrl, getHeaders(siteUrl)));
            // 分类节点
            Elements elements = doc.select("ul.type-slide > li a");
            JSONArray classes = new JSONArray();
            for (Element ele : elements) {
                String name = ele.text();
                Matcher mather = regexCategory.matcher(ele.attr("href"));
                if (!mather.find())
                    continue;
                String id = mather.group(1).trim();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type_id", id);
                jsonObject.put("type_name", name);
                classes.put(jsonObject);
            }
            JSONObject result = new JSONObject();
            result.put("class", classes);
            try {
                Elements list = doc.select("div.stui-pannel_bd ul.stui-vodlist li div.stui-vodlist__box");
                JSONArray videos = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    Element vod = list.get(i);
                    Matcher matcher = regexVid.matcher(vod.selectFirst(".stui-vodlist__thumb").attr("href"));
                    if (!matcher.find())
                        continue;
                    String title = vod.selectFirst(".title").text();
                    String cover = vod.selectFirst(".stui-vodlist__thumb").attr("data-original");
                    String remark = vod.selectFirst("span.pic-text").text();
                    String id = matcher.group(1);
                    JSONObject v = new JSONObject();
                    v.put("vod_id", id);
                    v.put("vod_name", title);
                    v.put("vod_pic", cover);
                    v.put("vod_remarks", remark);
                    videos.put(v);
                }
                result.put("list", videos);
            } catch (Exception e) {
                SpiderDebug.log(e);
            }
            return result.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    /**
     * 获取分类信息数据
     *
     * @param tid    分类id
     * @param pg     页数
     * @param filter 同homeContent方法中的filter
     * @param extend 筛选参数{k:v, k1:v1}
     * @return
     */
    @Override
    public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend) {
        try {
            // 获取分类数据的url
            String url = siteUrl + "/whole/" + tid + "/page/" + pg + ".html";
            String html = OkHttpUtil.string(url, getHeaders(url));
            Document doc = Jsoup.parse(html);
            JSONObject result = new JSONObject();
            int pageCount = 0;
            int page = -1;

            Elements pageInfo = doc.select(".stui-page li");
            if (pageInfo.size() == 0) {
                page = Integer.parseInt(pg);
                pageCount = page;
            } else {
                for (int i = 0; i < pageInfo.size(); i++) {
                    Element li = pageInfo.get(i);
                    Element a = li.selectFirst("a");
                    if (a == null)
                        continue;
                    String name = a.text();
                    if (page == -1 && li.hasClass("active")) {
                        Matcher matcher = regexPage.matcher(a.attr("href"));
                        if (matcher.find()) {
                            page = Integer.parseInt(matcher.group(1));
                        } else {
                            page = 0;
                        }
                    }
                    if (name.equals("尾页")) {
                        Matcher matcher = regexPage.matcher(a.attr("href"));
                        if (matcher.find()) {
                            pageCount = Integer.parseInt(matcher.group(1));
                        } else {
                            pageCount = 0;
                        }
                        break;
                    }
                }
            }

            JSONArray videos = new JSONArray();
            if (!html.contains("没有找到您想要的结果哦")) {
                Elements list = doc.select("ul.stui-vodlist li div.stui-vodlist__box");
                for (int i = 0; i < list.size(); i++) {
                    Element vod = list.get(i);
                    String title = vod.selectFirst(".title").text();
                    String cover = vod.selectFirst(".stui-vodlist__thumb").attr("data-original");
                    String remark = vod.selectFirst("span.pic-text").text();
                    Matcher matcher = regexVid.matcher(vod.selectFirst(".stui-vodlist__thumb").attr("href"));
                    if (!matcher.find())
                        continue;
                    String id = matcher.group(1);
                    JSONObject v = new JSONObject();
                    v.put("vod_id", id);
                    v.put("vod_name", title);
                    v.put("vod_pic", cover);
                    v.put("vod_remarks", remark);
                    videos.put(v);
                }
            }
            result.put("page", page);
            result.put("pagecount", pageCount);
            result.put("limit", 30);
            result.put("total", pageCount <= 1 ? videos.length() : pageCount * 30);

            result.put("list", videos);
            return result.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    /**
     * 视频详情信息
     *
     * @param ids 视频id
     * @return
     */
    @Override
    public String detailContent(List<String> ids) {
        try {
            // 视频详情url
            String url = siteUrl + "/show/" + ids.get(0) + ".html";
            Document doc = Jsoup.parse(OkHttpUtil.string(url, getHeaders(url)));
            JSONObject result = new JSONObject();
            JSONObject vodList = new JSONObject();

            // 取基本数据
            String cover = doc.selectFirst("a.stui-vodlist__thumb img").attr("data-original");
            String title = doc.selectFirst("a.stui-vodlist__thumb").attr("title");
            String desc = Jsoup.parse(doc.selectFirst("meta[name=description]").attr("content")).text();
            String category = "", area = "", year = "", remark = "", director = "", actor = "";
            Elements span_text_muted = doc.select("div.stui-content__detail span.text-muted");
            for (int i = 0; i < span_text_muted.size(); i++) {
                Element text = span_text_muted.get(i);
                String info = text.text();
                if (info.equals("类型：")) {
                    category = text.nextSibling().outerHtml().trim();
                } else if (info.equals("年份：")) {
                    year = text.nextSibling().outerHtml().trim();
                } else if (info.equals("地区：")) {
                    area = text.nextSibling().outerHtml().trim();
                } else if (info.equals("更新：")) {
                    remark = text.nextSibling().outerHtml().trim();
                } else if (info.equals("导演：")) {
                    director = text.nextSibling().outerHtml().trim();
                } else if (info.equals("主演：")) {
                    actor = text.nextSibling().outerHtml().trim();
                }
            }

            vodList.put("vod_id", ids.get(0));
            vodList.put("vod_name", title);
            vodList.put("vod_pic", cover);
            vodList.put("type_name", category);
            vodList.put("vod_year", year);
            vodList.put("vod_area", area);
            vodList.put("vod_remarks", remark);
            vodList.put("vod_actor", actor);
            vodList.put("vod_director", director);
            vodList.put("vod_content", desc);

            Map<String, String> vod_play = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    try {
                        int sort1 = playerConfig.getJSONObject(o1).getInt("or");
                        int sort2 = playerConfig.getJSONObject(o2).getInt("or");

                        if (sort1 == sort2) {
                            return 1;
                        }
                        return sort1 - sort2 > 0 ? 1 : -1;
                    } catch (JSONException e) {
                        SpiderDebug.log(e);
                    }
                    return 1;
                }
            });

            Elements sources = doc.select("div.playlist");

            for (int i = 0; i < sources.size(); i++) {
                Element source = sources.get(i);
                String sourceName = source.selectFirst("h3.title").text().trim();
                String tabHref = source.attr("href");
                boolean found = false;
                for (Iterator<String> it = playerConfig.keys(); it.hasNext(); ) {
                    String flag = it.next();
                    if (playerConfig.getJSONObject(flag).getString("sh").equals(sourceName)) {
                        sourceName = flag;
                        found = true;
                        break;
                    }
                }
                if (!found)
                    continue;
                String playList = "";
                Elements playListA = source.select("ul.stui-content__playlist > li > a");
                List<String> vodItems = new ArrayList<>();

                for (int j = 0; j < playListA.size(); j++) {
                    Element vod = playListA.get(j);
                    Matcher matcher = regexPlay.matcher(vod.attr("href"));
                    if (!matcher.find())
                        continue;
                    String playURL = matcher.group(1) + "-" + matcher.group(2) + "-" + matcher.group(3);
                    vodItems.add(vod.text() + "$" + playURL);
                }
                if (vodItems.size() > 0)
                    playList = TextUtils.join("#", vodItems);

                if (playList.length() == 0)
                    continue;

                vod_play.put(sourceName, playList);
            }

            if (vod_play.size() > 0) {
                String vod_play_from = TextUtils.join("$$$", vod_play.keySet());
                String vod_play_url = TextUtils.join("$$$", vod_play.values());
                vodList.put("vod_play_from", vod_play_from);
                vodList.put("vod_play_url", vod_play_url);
            }
            JSONArray list = new JSONArray();
            list.put(vodList);
            result.put("list", list);
            return result.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    /**
     * 获取视频播放信息
     *
     * @param flag     播放源
     * @param id       视频id
     * @param vipFlags 所有可能需要vip解析的源
     * @return
     */
    @Override
    public String playerContent(String flag, String id, List<String> vipFlags) {
        try {
            // 播放页 url
            String url = "http://1090ys8.com/play/" + id + ".html";
            Document doc = Jsoup.parse(OkHttpUtil.string(url, getHeaders(url)));
            Elements allScript = doc.select("script");
            JSONObject result = new JSONObject();
            for (int i = 0; i < allScript.size(); i++) {
                String scContent = allScript.get(i).html().trim();
                if (scContent.startsWith("var player_")) {
                    int start = scContent.indexOf('{');
                    int end = scContent.lastIndexOf('}') + 1;
                    String json = scContent.substring(start, end);
                    JSONObject player = new JSONObject(json);
                    if (playerConfig.has(player.getString("from"))) {
                        JSONObject pCfg = playerConfig.getJSONObject(player.getString("from"));
                        String videoUrl = player.getString("url");
                        String playUrl = pCfg.getString("pu");
                        String from = player.getString("from");
                        if (from.equals("youbo")) {
                            // 感谢猫大神的直连解密代码
                            HashMap<String, String> hds = getHeaders(url);
                            hds.put("Host", "jx1090ys5.hongfanedu.top");
                            hds.put("Referer", url);
                            String content1 = OkHttpUtil.string(playUrl + videoUrl, hds);
                            Document doc1 = Jsoup.parse(content1);
                            String url2 = doc1.selectFirst("iframe#WANG").attr("src");
                            String url2host = Uri.parse(url2).getHost();
                            hds.put("Host", url2host);
                            hds.put("Referer", "http://jx1090ys5.hongfanedu.top/");
                            String content2 = OkHttpUtil.string(url2, hds);
                            String finder = "var id=\"";
                            start = content2.indexOf(finder) + finder.length();
                            end = content2.indexOf('\"', start);
                            String vvid = content2.substring(start, end);
                            finder = "var sk=\"";
                            start = content2.indexOf(finder) + finder.length();
                            end = content2.indexOf('\"', start);
                            String skey = content2.substring(start, end);
                            finder = "var pt=\"";
                            start = content2.indexOf(finder) + finder.length();
                            end = content2.indexOf('\"', start);
                            String pt = content2.substring(start, end);
                            finder = "var ti=\"";
                            start = content2.indexOf(finder) + finder.length();
                            end = content2.indexOf('\"', start);
                            String time = content2.substring(start, end);
                            int bkn = 0x195c;
                            for (int j = 0x0, all = skey.length(); all > j; ++j) {
                                bkn += ((bkn << 5) + (byte) skey.charAt(j));
                            }
                            bkn = 0x7fffffff & bkn;
                            int gtk1 = 0x0;
                            for (int j = 0x0; j < pt.length(); j += 0x4) {
                                gtk1 += Integer.parseInt(String.format("%c%c%c%c", pt.charAt(j), pt.charAt(j + 0x1), pt.charAt(j + 0x2), pt.charAt(j + 0x3)), 0x10);
                                gtk1 %= 0x400a;
                            }
                            int offset = gtk1 % 10;
                            int gtk = 0x0;
                            for (int j = 0x0; j < pt.length(); j++) {
                                gtk += ((byte) pt.charAt(j)) * (j + offset);
                                gtk %= gtk1;
                            }
                            String finalVideoUrl = "http://" + url2host + "/hls/play/" + vvid + "%7C" + time + "%7C" + skey + "%7C" + pt + "%7C" + bkn + "%7C" + gtk + ".m3u8";
                            result.put("parse", pCfg.getInt("sn"));
                            result.put("playUrl", "");
                            result.put("url", finalVideoUrl);
                            result.put("header", "{\"Referer\":\" " + url2 + "\"}");
                        } else {
                            result.put("parse", pCfg.getInt("sn"));
                            result.put("playUrl", playUrl);
                            result.put("url", videoUrl);
                            result.put("header", "");
                        }
                    }
                    break;
                }
            }
            return result.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    /**
     * 搜索
     *
     * @param key
     * @param quick 是否播放页的快捷搜索
     * @return
     */
    @Override
    public String searchContent(String key, boolean quick) {
        try {
            long currentTime = System.currentTimeMillis();
            String url = siteUrl + "/index.php/ajax/suggest?mid=1&wd=" + URLEncoder.encode(key) + "&limit=10&timestamp=" + currentTime;
            JSONObject searchResult = new JSONObject(OkHttpUtil.string(url, getHeaders(url)));
            JSONObject result = new JSONObject();
            JSONArray videos = new JSONArray();
            if (searchResult.getInt("total") > 0) {
                JSONArray lists = new JSONArray(searchResult.getString("list"));
                for (int i = 0; i < lists.length(); i++) {
                    JSONObject vod = lists.getJSONObject(i);
                    String id = vod.getString("id");
                    String title = vod.getString("name");
                    String cover = vod.getString("pic");
                    JSONObject v = new JSONObject();
                    v.put("vod_id", id);
                    v.put("vod_name", title);
                    v.put("vod_pic", cover);
                    v.put("vod_remarks", "");
                    videos.put(v);
                }
            }
            result.put("list", videos);
            return result.toString();
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }
}
