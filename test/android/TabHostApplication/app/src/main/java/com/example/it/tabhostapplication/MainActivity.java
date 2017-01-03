package com.example.it.tabhostapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("TabHostTest");
        tabHost=(TabHost)findViewById(R.id.tabhost);
        //TabHost를 설정할 때 가장 먼저 호출해 주어야함
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.cat);
        tab1.setIndicator("고양이");

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.dog);
        tab2.setIndicator("강아지");

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setContent(R.id.rabbit);
        tab3.setIndicator("토끼");

        //TabHost에 TabSpec를 등록함
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
}
