package com.ui.Login;

import com.mvpdemo.BasePresenter;
import com.mvpdemo.BaseView;

public class LoginContranct  {
    interface View extends BaseView
    {

    }
    interface  Presenter extends BasePresenter<View> {
        void test();
    }
}
