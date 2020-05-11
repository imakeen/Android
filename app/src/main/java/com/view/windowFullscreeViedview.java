package com.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class windowFullscreeViedview extends VideoView {
    public windowFullscreeViedview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public windowFullscreeViedview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(0, widthMeasureSpec);
        int heigh = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, heigh);

    }
}
