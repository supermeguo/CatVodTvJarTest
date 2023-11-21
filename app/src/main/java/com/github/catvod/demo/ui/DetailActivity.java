package com.github.catvod.demo.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.github.catvod.crawler.Spider;
import com.github.catvod.demo.R;
import com.github.catvod.demo.adapter.PlayConfigAdapter;
import com.github.catvod.demo.adapter.VideoBean;
import com.github.catvod.demo.bean.DetailBean;
import com.github.catvod.demo.bean.PlayBean;
import com.github.catvod.demo.inter.MyOnItemClickListener;
import com.github.catvod.demo.utlis.DefaultConfig;
import com.github.catvod.demo.utlis.XpathInstance;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TextView tvDtName;
    private WebView myWebView;
    private SysWebClient mSysWebClient;
    private boolean loadFound = false;
    private String vodName;
    private Handler mHandler;

    @Override
    protected int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        detailContent = intent.getStringExtra("detailContent");
        Log.i("dddddd", "detailContent=" + detailContent);
        DetailBean detailBean = new Gson().fromJson(detailContent, DetailBean.class);
        List<DetailBean.ListBean> list = detailBean.getList();
        if (list == null || list.size() == 0) {
            return;
        }
        DetailBean.ListBean listBean = list.get(0);
        Picasso.get().load(listBean.getVod_pic()).into(ivDtPic);
        vodName = listBean.getVod_name();
        tvDtName.setText(vodName);

        tvDtLeixing.setText("类型：" + listBean.getType_name());
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
        initParseCountime();
        ivDtPic = findViewById(R.id.ivDtPic);
        tvDtName = findViewById(R.id.tvDtName);
        tvDtLeixing = findViewById(R.id.tvDtLeixing);
        tvDtYear = findViewById(R.id.tvDtYear);
        tvDtAre = findViewById(R.id.tvDtAre);
        tvDtyanyuan = findViewById(R.id.tvDtyanyuan);
        tvDtDaoyan = findViewById(R.id.tvDtDaoyan);
        tvDtDec = findViewById(R.id.tvDtDec);
        rePlayFrom = findViewById(R.id.rePlayFrom);
        playConfigAdapter = new PlayConfigAdapter();
        rePlayFrom.setAdapter(playConfigAdapter);

        playConfigAdapter.setOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onClickItem(String playerContent) {
                if (TextUtils.isEmpty(playerContent)) {
                    Toast.makeText(mContext, "播放地址为空", Toast.LENGTH_SHORT).show();
                } else {
                    initWebview(playerContent);
                }
            }
        });

    }

    private void initParseCountime() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 100:
                        stopParse();
                        Toast.makeText(mContext, "解析失败", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    void stopParse() {
        mHandler.removeMessages(100);
        stopLoadWebView(false);
        loadFound = false;
    }

    private void initWebview(String playerContent) {
        myWebView = new WebView(mContext);
        myWebView.setFocusable(false);
        myWebView.setFocusableInTouchMode(false);
        myWebView.clearFocus();
        myWebView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        myWebView.setFocusable(false);
        myWebView.setFocusableInTouchMode(false);
        myWebView.clearFocus();
        myWebView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        /* 添加webView配置 */
        final WebSettings settings = myWebView.getSettings();
        settings.setNeedInitialFocus(false);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        /* 添加webView配置 */
        //设置编码
        settings.setDefaultTextEncodingName("utf-8");
        settings.setUserAgentString(myWebView.getSettings().getUserAgentString());
        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return false;
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return true;
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return true;
            }
        });
        mSysWebClient = new SysWebClient();
        myWebView.setWebViewClient(mSysWebClient);
        Toast.makeText(mContext, "正在解析播放地址", Toast.LENGTH_SHORT).show();
        JsonObject obj = JsonParser.parseString(playerContent).getAsJsonObject();
        String url = obj.get("url").toString();
        url = url.substring(1, url.length() - 1);
        Log.i("dddddd", "url=" + url);
        myWebView.clearCache(true);
        mHandler.removeMessages(100);
        stopParse();

        myWebView.loadUrl(url);
        mHandler.sendEmptyMessageDelayed(100, 20 * 1000);
    }

    private class SysWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (url.contains("about:blank")) {
                mHandler.removeMessages(100);
            }
            Log.i("dddddd", "onPageStarted url=" + url);
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            Log.i("dddddd", "onReceivedHttpError errorResponse=" + errorResponse.toString());
            stopParse();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Log.i("dddddd", "onReceivedError error=" + error.toString());
            stopParse();
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            Log.i("dddddd", "onReceivedSslError error=" + error.toString());
            stopParse();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }

        WebResourceResponse checkIsVideo(String url, HashMap<String, String> headers) {
            if (url.endsWith("/favicon.ico")) {
                return new WebResourceResponse("image/png", null, null);
            }
            Log.i("dddddd", "checkIsVideo    " + url);
            if (loadFound) {
                return null;
            }
            if (checkVideoFormat(url)) {
                stopLoadWebView(false);
                loadFound = true;
                mHandler.removeMessages(100);
                Intent intent = new Intent(mContext, PlayActivity.class);
                intent.putExtra("videourl", url);
                intent.putExtra("vodName", vodName);
                startActivity(intent);
            }

            return null;
        }

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            WebResourceResponse response = checkIsVideo(url, null);
            if (response == null)
                return super.shouldInterceptRequest(view, url);
            else
                return response;
        }

        @Nullable
        @Override
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            String url = "";
            try {
                url = request.getUrl().toString();
            } catch (Throwable th) {

            }
            Log.i("dddddd", "shouldInterceptRequest url=" + url);
            HashMap<String, String> webHeaders = new HashMap<>();
            try {
                Map<String, String> hds = request.getRequestHeaders();
                for (String k : hds.keySet()) {
                    if (k.equalsIgnoreCase("user-agent")
                            || k.equalsIgnoreCase("referer")
                            || k.equalsIgnoreCase("origin")) {
                        webHeaders.put(k, " " + hds.get(k));
                    }
                }
            } catch (Throwable th) {

            }
            WebResourceResponse response = checkIsVideo(url, webHeaders);
            if (response == null)
                return super.shouldInterceptRequest(view, request);
            else
                return response;
        }

        @Override
        public void onLoadResource(WebView webView, String url) {
            super.onLoadResource(webView, url);
        }
    }

    void stopLoadWebView(boolean destroy) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (myWebView != null) {
                    myWebView.stopLoading();
//                    myWebView.loadUrl("about:blank");
                    if (destroy) {
                        myWebView.clearCache(true);
                        myWebView.removeAllViews();
                        myWebView.destroy();
                        myWebView = null;
                    }
                }
                if (myWebView != null) {
                    myWebView.stopLoading();
//                    myWebView.loadUrl("about:blank");
                    if (destroy) {
                        myWebView.clearCache(true);
                        myWebView.removeAllViews();
                        myWebView.destroy();
                        myWebView = null;
                    }
                }
            }
        });
    }

    boolean checkVideoFormat(String url) {
        Spider xpath = XpathInstance.getInstance().getXpath();
        if (xpath != null && xpath.manualVideoCheck()) {
            return xpath.isVideoFormat(url);
        }
        return DefaultConfig.isVideoFormat(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopLoadWebView(true);
        mHandler.removeMessages(100);
    }

    @Override
    protected void onPause() {
        super.onPause();
        loadFound = false;
    }
}
