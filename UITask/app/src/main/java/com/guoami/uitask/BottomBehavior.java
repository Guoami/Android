package com.guoami.uitask;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;


/**
 * Created by OBR on 2017/4/6.
 */

public class BottomBehavior extends CoordinatorLayout.Behavior<View> {

    private VelocityTracker mVelocityTracker;
    private float translationY;

    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        translationY = Math.abs(dependency.getTop());
        child.setTranslationY(translationY);
        return true;
    }

//    @Override
//    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent event) {
//        if(null == mVelocityTracker) {
//            mVelocityTracker = VelocityTracker.obtain();
//        }
//        mVelocityTracker.addMovement(event);
//        switch(event.getAction()) {
//            case MotionEvent.ACTION_UP:
//                while(mVelocityTracker.getYVelocity()>400f) {
//                    child.setTranslationY(translationY);
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mVelocityTracker.computeCurrentVelocity(1000);
//                break;
//        }
//        return true;
//    }

}
