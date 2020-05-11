package com.util;

import android.os.Handler;

public class CustomCountTimer implements Runnable {
    private int time;
    private int countDowntime;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    //1.时时去回掉
    //2.支持动态传入
    //3.每过一秒 总数减一
    //4.总时间倒计时为0时，要完成回调。

    public CustomCountTimer(int time, ICountDownHandler countDownHandler) {
        this.time = time;
        this.countDownHandler = countDownHandler;
        handler = new Handler();
        countDowntime = time;
    }

    @Override
    public void run() {
        if (isRun) {
            if (countDownHandler != null) {
                countDownHandler.onTicker(countDowntime);
            }
            if (countDowntime == 0) {
                cancal();
                if (countDownHandler != null) {
                    countDownHandler.onFinish();
                }
            } else {

                countDowntime = time--;
                handler.postDelayed(this, 1000);

            }
        }
    }

    public void start() {
        isRun = true;
        handler.post(this);
    }

    public void cancal() {
        isRun = false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownHandler {
        void onTicker(int time);

        void onFinish();
    }

}
