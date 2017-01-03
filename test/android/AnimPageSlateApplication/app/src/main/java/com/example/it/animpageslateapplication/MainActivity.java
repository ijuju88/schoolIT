package com.example.it.animpageslateapplication;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button BtnOnOff;
    LinearLayout InLinear;
    Animation AnimLeft, AnimRigth;
    boolean isPageOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnOnOff=(Button)findViewById(R.id.btnonoff);
        InLinear=(LinearLayout)findViewById(R.id.inLinear);

        AnimLeft= AnimationUtils.loadAnimation(this, R.anim.translate_left);
        AnimRigth= AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingPageAnimationListener animListener= new SlidingPageAnimationListener();

        AnimLeft.setAnimationListener(animListener);
        AnimRigth.setAnimationListener(animListener);

        BtnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen){
                    InLinear.startAnimation(AnimRigth);
                }else{
                    InLinear.setVisibility(View.VISIBLE);
                    InLinear.startAnimation(AnimLeft);
                }
            }
        });
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {}

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                InLinear.setVisibility(View.INVISIBLE);
               BtnOnOff.setText("열기");
                isPageOpen=false;
            }else{
                BtnOnOff.setText("닫기");
                isPageOpen=true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {}
    }
}
