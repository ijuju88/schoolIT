package com.example.it.test2application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by it on 2016-12-30.
 */

public class CustomerEntActivity extends AppCompatActivity {
    TextView TvCusName, TvCusPhone;
    Button BtnCusentExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerent);

        TvCusName=(TextView) findViewById(R.id.tvname);
        TvCusPhone=(TextView) findViewById(R.id.tvphone);
        BtnCusentExit=(Button) findViewById(R.id.cusentexit);

        BtnCusentExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
