package com.ui.liangxi;

import com.mvpdemo.BasePresenterImpl;

public class MainPresenter extends BasePresenterImpl<MainContranct.View>
        implements MainContranct.Presenter {

    @Override
    public void get() {
       mView.get();
    }
}
