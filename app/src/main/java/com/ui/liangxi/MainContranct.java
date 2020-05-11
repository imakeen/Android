package com.ui.liangxi;

import com.mvpdemo.BasePresenter;
import com.mvpdemo.BaseView;

import butterknife.BindView;

public class MainContranct {
    interface View extends  BaseView {
        void  get();
    }

    interface Presenter extends BasePresenter<View> {

        void  get();
    }
}
