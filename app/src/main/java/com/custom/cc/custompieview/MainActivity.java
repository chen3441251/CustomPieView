package com.custom.cc.custompieview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PieView mPieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPieView = new PieView(this);
        setContentView(R.layout.activity_main);
        mPieView = (PieView) findViewById(R.id.pieView);
        //模拟创建数据
        initData();
    }

    private void initData() {
        ArrayList<PieData> data = new ArrayList<>();
        PieData one = new PieData("one", 25);
        PieData two = new PieData("two", 40);
        PieData three = new PieData("three", 59);
        PieData four = new PieData("four", 11);
        PieData five = new PieData("five", 60);
        PieData six = new PieData("six", 160);
        data.add(one);
        data.add(two);
        data.add(three);
        data.add(four);
        data.add(five);
        data.add(six);
        //模拟数据设置进PieView
        mPieView.setData(data);
    }
}
