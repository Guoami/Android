package com.guoami.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();//初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0;i < 2;i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"),R.drawable.pp1);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"),R.drawable.pp2);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"),R.drawable.pp3);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("watermelon"),R.drawable.pp4);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("pear"),R.drawable.pp5);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("grape"),R.drawable.pp6);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("pineapple"),R.drawable.pp7);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("strawberry"),R.drawable.pp8);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("cherry"),R.drawable.pp9);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("mango"),R.drawable.pp10);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i=0;i < length;i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
