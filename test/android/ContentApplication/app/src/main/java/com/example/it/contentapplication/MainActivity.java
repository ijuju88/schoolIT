package com.example.it.contentapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button Btn, Btn2;
    int ro = 0;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn = (Button) findViewById(R.id.btn);
        registerForContextMenu(Btn);
        Btn2 = (Button) findViewById(R.id.btnSize);
        registerForContextMenu(Btn2);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater;
        Log.i("Log", v.toString());
        if (v == Btn) {
            menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu1, menu);
        }
        else if (v == Btn2) {
            menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu2, menu);
            if (flag) {
                menu.getItem(R.id.sizeAdd).setEnabled(false);
                menu.getItem(R.id.sizeDel).setEnabled(true);
            } else {
                menu.getItem(R.id.sizeAdd).setEnabled(true);
                menu.getItem(R.id.sizeDel).setEnabled(false);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.i("Log", item.toString());
        //return super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.red:
                Btn.setTextColor(Color.RED);
                return true;
            case R.id.blue:
                Btn.setTextColor(Color.BLUE);
                return true;
            case R.id.green:
                Btn.setTextColor(Color.GREEN);
                return true;

            case R.id.rotate:
                if (ro <= 360) {
                    ro += 45;
                    Btn2.setRotation(ro);
                } else {
                    Toast.makeText(getApplicationContext(), "360도이상입니다", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.sizeAdd:
                flag = true;
                Btn2.setScaleX(2);
                Btn2.setScaleY(2);
                return true;
            case R.id.sizeDel:
                flag = false;
                Btn2.setScaleX(1);
                Btn2.setScaleY(1);
                return true;

        }
        return false;
    }
}
