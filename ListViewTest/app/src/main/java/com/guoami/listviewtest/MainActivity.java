package com.guoami.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    //private String[] data = { "Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple",
    //    "Strawberry","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple",
    //        "Strawberry","Cherry","Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();//初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        //        MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i=0;i<2;i++) {
            Fruit apple = new Fruit("Apple",R.drawable.pp1);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.pp2);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.pp6);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.pp10);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.pp7);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.pp4);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pp8);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.pp9);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.drawable.pp3);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.pp5);
            fruitList.add(mango);
        }
    }
}
