package com.guoami.uitask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {


    private TextView textView_xin;

    private TextView textView_xined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("");//设置为空
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollingActivity.this.finish();//close退出
            }
        });
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);//设置菜单按钮点击事件

        textView_xin = (TextView) findViewById(R.id.xin);
        textView_xined = (TextView) findViewById(R.id.xined);
        textView_xined.setVisibility(View.GONE);//先隐藏‘已收藏’控件
        textView_xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_xin.setVisibility(View.GONE);//隐藏收藏控件
                textView_xined.setVisibility(View.VISIBLE);//显示已收藏控件
                Toast.makeText(ScrollingActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
            }
        });
        textView_xined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_xined.setVisibility(View.GONE);//隐藏已收藏控件
                textView_xin.setVisibility(View.VISIBLE);//显示收藏控件
                Toast.makeText(ScrollingActivity.this,"取消收藏",Toast.LENGTH_SHORT).show();
            }
        });
        ImageView commentIcon = (ImageView) findViewById(R.id.comment_icon);
        commentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScrollingActivity.this,"评论",Toast.LENGTH_SHORT).show();
            }
        });
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

}
