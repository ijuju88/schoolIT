package com.example.it.test2application;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by it on 2016-12-30.
 */

public class CustomerActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CUSDATA = 1100;
    EditText EtCusName, EtCusPhone;
    Button BtnCusEnt, BtnCusExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);

        EtCusName=(EditText)findViewById(R.id.etcusName);
        EtCusPhone=(EditText)findViewById(R.id.etcusPhone);
        BtnCusEnt=(Button) findViewById(R.id.cusent);
        BtnCusExit=(Button) findViewById(R.id.cusexit);

        BtnCusEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultname=EtCusName.getText().toString();
                String resultphone=EtCusPhone.getText().toString();

                    Intent intentmenu= new Intent(getApplicationContext(), CustomerEntActivity.class);
                    intentmenu.putExtra("cusname", resultname);
                    intentmenu.putExtra("cusphone", resultphone);
                    startActivityForResult(intentmenu, REQUEST_CODE_CUSDATA);
            }
        });

        BtnCusExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_CUSDATA) {
            Log.i("test", ""+data.getStringExtra("re"));
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
