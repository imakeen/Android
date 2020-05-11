package com.ui.welcome;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.myapplication.R;
import com.mvpdemo.MvpActivity;
import com.ui.liangxi.MainActivity;
import com.util.CustomCountTimer;
import com.view.windowFullscreeViedview;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class WelcomeActivity extends MvpActivity<WelcomeContranct.View, WelcomePresenter> implements WelcomeContranct.View {
    private Unbinder unbinder;
    @BindView(R.id.tv_spik)
    TextView tv_spik;

    @BindView(R.id.wv_welcome)
    windowFullscreeViedview vv_play;

    private CustomCountTimer timer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {
        setTimer();
        play();
    }

    private void play() {
        vv_play.setVideoURI(Uri.parse(("android.resource://") + getPackageName() + File.separator + R.raw.splash));

        vv_play.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        vv_play.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    private void setTimer() {
        timer = new CustomCountTimer(5, new CustomCountTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                tv_spik.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                tv_spik.setText("跳过");
            }
        });
        timer.start();
    }

    @OnClick({R.id.tv_spik})
    public void onClick(View view) {
        ActivityUtils.startActivity(MainActivity.class);
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancal();
    }

    @Override
    public void onFailed() {

    }
}
