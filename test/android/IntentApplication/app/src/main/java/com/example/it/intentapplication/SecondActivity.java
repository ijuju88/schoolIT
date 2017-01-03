package com.example.it.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SecondActivity extends AppCompatActivity {
    Button BtnResult;
    int hapTotValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second 액티비티");

        BtnResult=(Button)findViewById(R.id.bthresult);

        Intent inIntent=getIntent();
        final int hapValue1=inIntent.getIntExtra("Num1", 0);
        final String OpcodeValue=inIntent.getStringExtra("Opcode");
        final int hapValue2=inIntent.getIntExtra("Num2", 0);

        switch (OpcodeValue){
            case "+":
                hapTotValue=hapValue1+hapValue2;
                break;
            case "-":
                hapTotValue=hapValue1-hapValue2;
                break;
            case "*":
                hapTotValue=hapValue1*hapValue2;
                break;
            case "/":
                hapTotValue=hapValue1/hapValue2;
                break;
        }

        BtnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent=new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", hapTotValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
