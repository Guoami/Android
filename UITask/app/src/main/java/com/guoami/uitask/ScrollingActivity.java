package com.guoami.uitask;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity  {


//    private static final Interpolator interpolator = new FastOutLinearInInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Android 笔试题");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_close);//设置close图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollingActivity.this.finish();//close退出
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);//设置菜单按钮点击事件


//        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.bottom_comment);
//        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);

//        BottomBehavior bottomBehavior = new BottomBehavior();
//        bottomBehavior.onDependentViewChanged(coordinatorLayout,relativeLayout,appBarLayout);

//        viewSlop = ViewConfiguration.get(this).getScaledTouchSlop();

//        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN://手指按下
//                        lastY = motionEvent.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE://手指滑动
//                        float disY = motionEvent.getY()-lastY;
//                        if (Math.abs(disY)>viewSlop) {
//                            isUpSlide = disY < 0;
//                            isDownSlide = disY > 0;
//                            if(isUpSlide) {
//                                if(!isToolsHide){
//                                    relativeLayout.setVisibility(View.INVISIBLE);
//                                    isToolsHide = false;
//                                }
//                            }else if(isDownSlide) {
//                                if(isToolsHide){
//                                    relativeLayout.setVisibility(View.VISIBLE);
//                                    isToolsHide = true;
//                                }
//                            }
//                        }
//                        lastY = motionEvent.getY();
//                        break;
//                }
//                gestureDetector.onTouchEvent(motionEvent);
//                return false;
//            }
//        });

//        relativeLayout.setOnTouchListener(new setOnTouchListener());
    }

//    private class setOnTouchListener implements View.OnTouchListener {
//        @Override
//        public boolean onTouch(View v, MotionEvent motionEvent){
//            float x = motionEvent.getX();
//            float y = motionEvent.getY();
//            Log.d("you touch","fhjehr");
//            return true;
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String msg = "";
            switch (item.getItemId()) {
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }
            if(!msg.equals("")) {
                Toast.makeText(ScrollingActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };


//    private void hide(final View view) {
//        ViewPropertyAnimator animator = view.animate().translationY(view.getHeight()).setInterpolator(interpolator).setDuration(200);
//        animator.setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                view.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                show(view);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//        animator.start();
//    }
//    //
//    private void show(final View view) {
//        ViewPropertyAnimator animator = view.animate().translationY(0).setInterpolator(interpolator).setDuration(200);
//        animator.setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                view.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                hide(view);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//        animator.start();
//    }

}
