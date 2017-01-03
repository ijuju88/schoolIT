package com.example.it.intent2application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class TextActivity extends AppCompatActivity {
    EditText name, age, phone;
    Button BtnReturn, BtnSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        name=(EditText)findViewById(R.id.etname);
        age=(EditText)findViewById(R.id.etage);
        phone=(EditText)findViewById(R.id.etphone);

        BtnReturn=(Button)findViewById(R.id.btnreturn);
        BtnSet=(Button)findViewById(R.id.btnset);

        BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Name", name.getText().toString());
                intent.putExtra("Age", age.getText().toString());
                intent.putExtra("Phone", phone.getText().toString());

                Toast.makeText(getApplicationContext(), "name1>"+
                        name.getText().toString(),Toast.LENGTH_SHORT).show();

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        BtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                age.setText("");
                phone.setText("");
            }
        });
    }
}
