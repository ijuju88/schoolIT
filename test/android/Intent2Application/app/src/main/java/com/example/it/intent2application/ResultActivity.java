package com.example.it.intent2application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView TvName, TvAge, TvPhone;
    String nametext, agetext, phonetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TvName=(TextView)findViewById(R.id.tvname);
        TvAge=(TextView)findViewById(R.id.tvage);
        TvPhone=(TextView)findViewById(R.id.tvphone);

        Intent intent=getIntent();
        nametext=intent.getStringExtra("NameText");
        agetext=intent.getStringExtra("AgeText");
        phonetext=intent.getStringExtra("PhoneText");

        Toast.makeText(getApplicationContext(), nametext.toString(),Toast.LENGTH_SHORT).show();

        TvName.setText("이름 > "+nametext);
        TvAge.setText("나이 > "+agetext);
        TvPhone.setText("연락처 > "+phonetext);

    }

}
