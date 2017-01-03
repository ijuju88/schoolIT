package com.example.it.menutestapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView TvColor;
    int rot=0;
    int sc=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvColor=(TextView)findViewById(R.id.tvcolor);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        SubMenu subMenu=menu.addSubMenu("색상변경");
        subMenu.add(0,1,0,"빨강");
        subMenu.add(0,2,0,"파랑");
        subMenu.add(0,3,0,"그린");

        menu.add(0,4,0,"회전");
        menu.add(0,5,0,"2배확대");

      /*  MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu2, menu);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                //코드작성
                TvColor.setTextColor(Color.RED);
                return true;
            case 2:
                TvColor.setTextColor(Color.BLUE);
                return true;
            case 3:
                TvColor.setTextColor(Color.GREEN);
                return true;
            case 4:
                if(rot<=360) {
                    rot+=45;
                    TvColor.setRotation(rot);
                }else {
                    rot = 0;
                    TvColor.setRotation(rot);
                }
                return true;
            case 5:
                sc*=2;
                if(sc>10){
                    sc=10;
                }
                TvColor.setScaleX(sc);
                TvColor.setScaleY(sc);
                return true;
          /*  case R.id.red:
                //코드작성
                TvColor.setTextColor(Color.RED);
                return true;
            case R.id.blue:
                TvColor.setTextColor(Color.BLUE);
                return true;
            case R.id.green:
                TvColor.setTextColor(Color.GREEN);
                return true;
            case R.id.rotate:
                if(rot<=360) {
                    rot+=45;
                    TvColor.setRotation(rot);
                }else {
                    rot = 0;
                    TvColor.setRotation(rot);
                }
                return true;
            case R.id.enlarge:
                sc*=2;
                if(sc>10){
                    sc=10;
                }
                TvColor.setScaleX(sc);
                TvColor.setScaleY(sc);
                return true;*/
        }
        return false;
    }
}
