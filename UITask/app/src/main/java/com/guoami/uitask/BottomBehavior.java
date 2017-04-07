package com.guoami.uitask;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.R.attr.flipInterval;
import static android.R.attr.translationY;

/**
 * Created by OBR on 2017/4/6.
 */

public class BottomBehavior extends CoordinatorLayout.Behavior<View> {


    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float translationY = Math.abs(dependency.getTop());

        child.setTranslationY(translationY);
        return true;
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent motionEvent) {
        child.setTranslationY(100);
        return true;
    }
}
