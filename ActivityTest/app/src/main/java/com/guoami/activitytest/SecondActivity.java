package com.guoami.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //public static void actionStart(Context context) {
        //    Intent intent = new Intent(context,SecondActivity.class);
        //    context.startActivity(intent);
       // }
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is " + getTaskId());
        setContentView(R.layout.second_layout);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SecondActivity.actionStart(FirstActivity.this);
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);  
            }
        });
        //Intent intent = getIntent();
        //String data = intent.getStringExtra("extra_data");
        //Log.d("SecondActivity",data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }
}
