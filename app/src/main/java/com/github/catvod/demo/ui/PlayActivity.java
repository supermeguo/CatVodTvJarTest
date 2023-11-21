package com.github.catvod.demo.ui;

import android.content.Intent;
import android.util.Log;

import com.github.catvod.demo.R;
import com.github.catvod.demo.utlis.ScreenRotateUtils;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class PlayActivity extends BaseActivity implements ScreenRotateUtils.OrientationChangeListener{

    private JzvdStd mJzvdStd;

    @Override
    protected int getLayout() {
        return R.layout.activity_play;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String videourl = intent.getStringExtra("videourl");
        String vodName = intent.getStringExtra("vodName");
        Log.i("dddddd", "videourl=" + videourl);

        mJzvdStd = findViewById(R.id.jz_video);
        mJzvdStd.setUp(videourl
                , vodName);
        //        mJzvdStd.startPreloading(); //开始预加载，加载完等待播放
        mJzvdStd.startVideoAfterPreloading(); //如果预加载完会开始播放，如果未加载则开始加载
    }
    @Override
    public void orientationChange(int orientation) {
        if (orientation >= 45 && orientation <= 315 && mJzvdStd.screen == Jzvd.SCREEN_NORMAL) {
            changeScreenFullLandscape(ScreenRotateUtils.orientationDirection);
        } else if (((orientation >= 0 && orientation < 45) || orientation > 315) && mJzvdStd.screen == Jzvd.SCREEN_FULLSCREEN) {
            changeScrenNormal();
        }
    }
    /**
     * 竖屏并退出全屏
     */
    private void changeScrenNormal() {
        if (mJzvdStd != null && mJzvdStd.screen == Jzvd.SCREEN_FULLSCREEN) {
            mJzvdStd.autoQuitFullscreen();
        }
    }

    /**
     * 横屏
     */
    private void changeScreenFullLandscape(float x) {
        //从竖屏状态进入横屏
        if (mJzvdStd != null && mJzvdStd.screen != Jzvd.SCREEN_FULLSCREEN) {
            if ((System.currentTimeMillis() - Jzvd.lastAutoFullscreenTime) > 2000) {
                mJzvdStd.autoFullscreen(x);
                Jzvd.lastAutoFullscreenTime = System.currentTimeMillis();
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        ScreenRotateUtils.getInstance(this).stop();
        Jzvd.releaseAllVideos();

    }

    @Override
    protected void onResume() {
        super.onResume();

        ScreenRotateUtils.getInstance(this).start(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ScreenRotateUtils.getInstance(this.getApplicationContext()).setOrientationChangeListener(null);
    }

    @Override
    public void onBackPressed() {

        if (JzvdStd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
