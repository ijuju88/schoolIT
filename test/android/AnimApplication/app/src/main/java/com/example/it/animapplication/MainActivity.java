package com.example.it.animapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView IV;
    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IV=(ImageView)findViewById(R.id.imageView);

        anim= AnimationUtils.loadAnimation(this, R.anim.translate);
        IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IV.startAnimation(anim);
            }
        });

    }
}
