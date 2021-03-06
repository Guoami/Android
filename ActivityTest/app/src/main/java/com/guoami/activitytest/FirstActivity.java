package com.guoami.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+getTaskId());
        //Log.d("FirstActivity",this.toString());//打印活动实例
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               //String data = "Hello SecondActivity";
               Intent intent = new Intent (FirstActivity.this,SecondActivity.class);
               //intent.putExtra("extra_data",data);
               startActivity(intent);
               //Intent intent = new Intent(Intent.ACTION_VIEW);
               //intent.setData(Uri.parse("http://www.baidu.com"));
               //startActivity(intent);
               //Toast.makeText(FirstActivity.this,"You clicked Button 1", Toast.LENGTH_SHORT).show();
           }
        });

        Button button2=(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("10086"));
                startActivity(intent);
                //Toast.makeText(FirstActivity.this,"You clicked Button 2",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
        //return super.onCreateOptionsMenu(main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you Clicked Remove",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
