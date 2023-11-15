package com.github.catvod.demo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
}
