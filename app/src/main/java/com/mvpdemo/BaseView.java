package com.mvpdemo;

public interface BaseView {



    /**
     * 显示加载框
     *
     * @time 2019/12/27  15:47
     */
    void showLoading();


    /**
     * 隐藏加载看
     *
     * @time 2019/12/27  15:47
     */
    void dismissLoading();

    /**
     * 网络连接失败
     *
     * @time 2019/12/27  15:53
     */
    void onFailed();
}
