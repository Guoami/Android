package com.guoami.uitask;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class ScrollingActivity extends AppCompatActivity  {


    private boolean isToolsHide;

    private boolean isTopHide;

    private float lastY;//记录按下的坐标

    private float viewSlop;

    private boolean isUpSlide;

    private boolean isDownSlide;

    private GestureDetector gestureDetector;

    private static final int TIME_ANIMATION = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.main_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Android 笔试题");
        //toolbar.setTitleTextColor();//设置颜色
        //toolbar.setLogo(R.drawable.wait);
        //toolbar.setSubtitle("笔试题笔试题笔试题便会提比分合肥看爸妈家阿尔山东方额发恶风发");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.close);//设置close图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollingActivity.this.finish();//close退出
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);//设置菜单按钮点击事件

        viewSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        gestureDetector = new GestureDetector(this,new MyGestureListener());

        nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN://手指按下
                        lastY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE://手指滑动
                        float disY = motionEvent.getY()-lastY;
                        if (Math.abs(disY)>viewSlop) {
                            isUpSlide = disY < 0;
                            isDownSlide = disY > 0;
                            if(isUpSlide) {
                                if(!isToolsHide)
                                    hideTools();
                            }else if(isDownSlide) {
                                if(isToolsHide)
                                    showTools();
                            }
                        }
                        lastY = motionEvent.getY();
                        break;
                }
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });


//        RelativeLayout fab = (RelativeLayout) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

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

    //显示下方工具栏
    private void showTools() {
        LinearLayout comment_bottom = (LinearLayout) findViewById(R.id.content_bottom);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(comment_bottom,"y",comment_bottom.getY(),
                        comment_bottom.getY()-comment_bottom.getHeight());
        objectAnimator.setDuration(TIME_ANIMATION);
        ObjectAnimator.start();

        isToolsHide = false;
    }

    //隐藏工具栏
    private void hideTools() {
        LinearLayout comment_bottom = (LinearLayout) findViewById(R.id.content_bottom);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(comment_bottom,"y",comment_bottom.getY(),
                comment_bottom.getY()+comment_bottom.getHeight());
        objectAnimator.setDuration(TIME_ANIMATION);
        ObjectAnimator.start();

        isToolsHide = true;
    }

    //点按屏幕使ToolBar弹出
    private void showTop() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(toolbar,"y",toolbar.getY(),
                toolbar.getY()+toolbar.getHeight());
        objectAnimator.setDuration(TIME_ANIMATION);
        ObjectAnimator.start();

        isTopHide = false;

    }

    //点击屏幕使ToolBar隐藏
    private void hideTop() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(toolbar,"y",toolbar.getY(),
                toolbar.getY()-toolbar.getHeight());
        objectAnimator.setDuration(TIME_ANIMATION);
        ObjectAnimator.start();

        isTopHide = true;
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if(isToolsHide && isTopHide) {
                showTools();
                showTop();
            } else {
                hideTools();
                hideTop();
            }
            return super.onSingleTapConfirmed(e);
        }
        //函数内部可继续添加长按，双击，滑动等事件
    }
}
