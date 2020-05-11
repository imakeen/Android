package com.mvpdemo;

public interface BasePresenter<V extends BaseView> {
    /**
     * 绑定View
     *
     * @time 2019/12/27  15:55
     */
    void attachView(V view);


    /**
     * 分离View
     *
     * @time 2019/12/27  15:55
     */
    void detachView();
}
