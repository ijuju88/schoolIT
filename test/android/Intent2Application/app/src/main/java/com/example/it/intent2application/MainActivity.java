package com.example.it.intent2application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button BtnText, BtnResultText;
    String nametext="", agetext="", phonetext="";


    @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {

       if(requestCode==0 && resultCode==RESULT_OK){
           nametext = data.getStringExtra("Name");
           agetext = data.getStringExtra("Age");
           phonetext  = data.getStringExtra("Phone");
           Toast.makeText(getApplicationContext(), "name>"+nametext,Toast.LENGTH_SHORT).show();

       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnText = (Button) findViewById(R.id.btntext);
        BtnResultText = (Button) findViewById(R.id.btnresulttext);

        BtnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttext = new Intent(getApplicationContext(), TextActivity.class);
                startActivityForResult(intenttext,0);
            }
        });


        BtnResultText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outintent = new Intent(getApplicationContext(), ResultActivity.class);

                outintent.putExtra("NameText", nametext);
                outintent.putExtra("AgeText", agetext);
                outintent.putExtra("PhoneText", phonetext);

                startActivity(outintent);
            }
        });
    }

}
