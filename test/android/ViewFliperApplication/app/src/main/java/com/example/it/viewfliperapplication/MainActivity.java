package com.example.it.viewfliperapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button BtnStart, BtnStop;
    ViewFlipper  VFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnStart = (Button) findViewById(R.id.btnstart);
        BtnStop = (Button) findViewById(R.id.btnstop);
        VFlipper = (ViewFlipper) findViewById(R.id.vf);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VFlipper.showPrevious();
                VFlipper.startFlipping();
                VFlipper.setFlipInterval(1000);
            }
        });

        BtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VFlipper.stopFlipping();
               // VFlipper.showNext();
            }
        });
    }
}
