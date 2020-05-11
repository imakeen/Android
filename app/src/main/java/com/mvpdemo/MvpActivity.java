package com.mvpdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.example.myapplication.R;
import com.util.StatusBarUtil;

import java.lang.reflect.ParameterizedType;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class MvpActivity<V extends BaseView, T extends BasePresenterImpl<V>> extends
        AppCompatActivity implements BaseView {
    protected T mPresenter;
    private Unbinder unbinder;
    private Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        LogUtils.e(getClass().getSimpleName());
        initPresenter();
        init();
        titlebar();
    }

    /**
     * 状态栏
     *
     * @time 2020/4/18  9:23
     */
    private void titlebar() {
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.
                setRootViewFitsSystemWindows(this, true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清

            StatusBarUtil.setStatusBarColor(this, R.color.colorWrite);
        }

    }

    /**
     * 获取Activitv的控件
     *
     * @time 2019/12/27  16:50
     */
    protected abstract int getLayoutId();

    protected abstract void init();

    private void initPresenter() {
        mPresenter = getInstance(this, 1);
        // 完成Presenter和view的绑定
        if (mPresenter != null) {
            mPresenter.attachView(( V ) this);
        }
    }

    /**
     * 正在加载
     *
     * @time 2019/12/28  11:22
     */
    @Override
    public void showLoading() {
        if (dialog == null) {
            dialog = new Dialog(this, R.style.loading);
        }
        View view = getLayoutInflater().inflate(R.layout.loading, null);
        dialog.setContentView(view);
        dialog.show();


        //dialog.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    /**
     * 加载完成
     *
     * @time 2019/12/28  11:22
     */
    @Override
    public void dismissLoading() {

//        if (dialog != null) {
//            dialog.dismiss();
//        }
    }

    /**
     * 当界面销毁时解绑
     *
     * @time 2019/12/27  16:56
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        //解绑ButterKnife
//        if (unbinder != null) {
//            unbinder.unbind();
//        }
    }

    public <T> T getInstance(Object o, int i) {
        try {
            return (( Class<T> ) (( ParameterizedType ) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
