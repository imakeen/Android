package com.ui.welcome;

import com.mvpdemo.BasePresenter;
import com.mvpdemo.BaseView;

public class WelcomeContranct {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
