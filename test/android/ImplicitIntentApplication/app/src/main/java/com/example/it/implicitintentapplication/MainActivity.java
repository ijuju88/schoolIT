package com.example.it.implicitintentapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button BtnPhone, BtnWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnPhone=(Button)findViewById(R.id.btnphone);
        BtnWeb=(Button)findViewById(R.id.btnWeb);

        //전화다이얼누르는 앱으로들어감
        BtnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel:010-111-1111");
                Intent intent=new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        BtnWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri=Uri.parse("http://www.naver.co.kr");
                Intent intent=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}

