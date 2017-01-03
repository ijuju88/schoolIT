package com.example.it.timeapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button BtnStart, BtnEnd;
    RadioButton Rb1, Rb2;
    CalendarView Cv;
    TimePicker Tp;
    TextView TvResult;
    int cyear, cmonth, cday, thour, tminute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chr);
        BtnStart = (Button) findViewById(R.id.btnstart);
        BtnEnd = (Button) findViewById(R.id.btnend);
        Rb1 = (RadioButton) findViewById(R.id.rbdate);
        Rb2 = (RadioButton) findViewById(R.id.rbtime);
        Cv = (CalendarView) findViewById(R.id.calview);
        Tp = (TimePicker) findViewById(R.id.tp);
        TvResult = (TextView) findViewById(R.id.tvresult);

        setTitle("시간 예약");

        Cv.setVisibility(View.INVISIBLE);
        Tp.setVisibility(View.INVISIBLE);

        Rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cv.setVisibility(View.VISIBLE);
                Tp.setVisibility(View.INVISIBLE);
            }
        });

        Rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cv.setVisibility(View.INVISIBLE);
                Tp.setVisibility(View.VISIBLE);
            }
        });

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        BtnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                TvResult.setText(cyear+"년"+cmonth+"월"+cday+"일"+thour+":"+tminute+"예약완료");
            }
        });

        Cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                cyear=year;
                cmonth=month+1;//0부너 시작합니다(왠지 java.util.Calendar과 같은 맥락인가 봄)
                cday=dayOfMonth;
            }
        });

        Tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                thour=hourOfDay;
                tminute=minute;
            }
        });

    }
}
