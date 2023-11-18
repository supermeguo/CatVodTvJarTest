package com.github.catvod.demo.utlis;

import android.content.Context;

import com.github.catvod.demo.bean.FiltersBean;
import com.github.catvod.demo.bean.SortFilter;
import com.github.catvod.demo.bean.XshijueHomeListBean;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class JsonUtils {
    public static String getAssetsJson(Context mContext, String jsonPath) {
        try {
            // 打开assets目录中的文件
            InputStream inputStream = mContext.getAssets().open(jsonPath);

            // 从输入流创建InputStreamReader
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            // 从InputStreamReader创建BufferedReader
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // 读取文件中的每一行数据
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // 关闭输入流和读取器
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            // 获取JSON数据
            String jsonData = stringBuilder.toString();

            // 将JSON数据转换为JSONObject或JSONArray进行进一步处理
            return jsonData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static XshijueHomeListBean getFilters(XshijueHomeListBean xshijueHomeListBean, String homeContent) {
        JsonObject obj = JsonParser.parseString(homeContent).getAsJsonObject();

        List<XshijueHomeListBean.ClassBean> classX = xshijueHomeListBean.getClassX();

        if (obj.has("filters")) {
            LinkedHashMap<String, ArrayList<SortFilter>> sortFilters = new LinkedHashMap<>();
            JsonObject filters = obj.getAsJsonObject("filters");
            for (String key : filters.keySet()) {
                ArrayList<SortFilter> sortFilter = new ArrayList<>();
                JsonElement one = filters.get(key);
                if (one.isJsonObject()) {
                    sortFilter.add(getSortFilter(one.getAsJsonObject()));
                } else {
                    for (JsonElement ele : one.getAsJsonArray()) {
                        sortFilter.add(getSortFilter(ele.getAsJsonObject()));
                    }
                }
                sortFilters.put(key, sortFilter);
                for (XshijueHomeListBean.ClassBean bean : classX) {
                    if (sortFilters.containsKey(bean.getType_id())&&sortFilters.get(bean.getType_id())!=null) {
                        bean.setFilters(sortFilters.get(bean.getType_id()));
                    }
                }

            }
        }
        return xshijueHomeListBean;
    }
    public static SortFilter getSortFilter(JsonObject obj) {
        String key = obj.get("key").getAsString();
        String name = obj.get("name").getAsString();
        JsonArray kv = obj.getAsJsonArray("value");
        LinkedHashMap<String, String> values = new LinkedHashMap<>();
        for (JsonElement ele : kv) {
            values.put(ele.getAsJsonObject().get("n").getAsString(), ele.getAsJsonObject().get("v").getAsString());
        }
      SortFilter filter = new SortFilter();
        filter.key = key;
        filter.name = name;
        filter.values = values;
        return filter;
    }
}
