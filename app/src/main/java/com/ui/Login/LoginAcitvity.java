package com.ui.Login;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.myapplication.R;
import com.mvpdemo.MvpActivity;
import com.ui.liangxi.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginAcitvity extends MvpActivity<LoginContranct.View, LoginPresenter> implements
        LoginContranct.View {
    @BindView(R.id.tv)
    TextView textView;
    @BindView(R.id.button1)
    Button button;
    @BindView(R.id.image)
    ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show();
        AnimatorSet set = ( AnimatorSet ) AnimatorInflater.loadAnimator(this,
                R.animator.property_animator);
        set.setTarget(textView);
        set.start();

    }

    @OnClick(R.id.button1)
    public void onClick(View view) {
        ActivityUtils.startActivity(MainActivity.class);

        //视觉动画
        //Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        //imageView.startAnimation(hyperspaceJump);


//        startActivityForResult(setSmsAppIntent, your-result-code);

    }

    @Override
    public void onFailed() {

    }
}
