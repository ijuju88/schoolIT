package com.example.it.progressapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button BtnShow, BtnClose;
    TextView TvShow, TvShow2;
    ProgressBar progressBar;
    int i=20;

    private SeekBar seekBar;
    private int j=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnShow=(Button)findViewById(R.id.btnshow);
        BtnClose=(Button)findViewById(R.id.btnclose);
        progressBar=(ProgressBar) findViewById(R.id.progressBar1);
        TvShow=(TextView)findViewById(R.id.tvshow);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100); //최대값

        BtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i+=5;
                if(i <0){
                    i=0;
                }else if(i >100){
                    i=100;
                }
                progressBar.setProgress(i); //현재값
                TvShow.setText(i+"%");
            }
        });

        BtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                progressBar.setProgress(i); //현재값
                TvShow.setText(i+"%");
            }
        });

        TvShow2=(TextView)findViewById(R.id.tvshow2);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress <10){
                    progress=10;
                }else if(progress >100){
                    progress=100;
                }
                j=progress;
                TvShow2.setText(j+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
