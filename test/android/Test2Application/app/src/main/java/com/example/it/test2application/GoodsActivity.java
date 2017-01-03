package com.example.it.test2application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;


/**
 * Created by it on 2016-12-30.
 */

public class GoodsActivity extends AppCompatActivity {
    EditText EtGoodCode, EtGoodName;
    Button BtnGoodEnt, BtnGoodExit;
    LinearLayout li, linear;
    TextView table1, table2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods);

        EtGoodCode=(EditText)findViewById(R.id.etgoodcode);
        EtGoodName=(EditText)findViewById(R.id.etgoodname);
        BtnGoodEnt=(Button) findViewById(R.id.goodent);
        BtnGoodExit=(Button) findViewById(R.id.goodsexit);

        BtnGoodEnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultcode=EtGoodCode.getText().toString();
                String resultname=EtGoodName.getText().toString();

                li = (LinearLayout)findViewById(R.id.list);
                linear = new LinearLayout(GoodsActivity.this);
                linear.setOrientation(LinearLayout.HORIZONTAL);
                table1 = new TextView(GoodsActivity.this);
                table2 = new TextView(GoodsActivity.this);
                table1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
                table2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1.0f));
                table1.setText(resultcode);
                table2.setText(resultname);
                linear.addView(table1);
                linear.addView(table2);
                li.addView(linear);
                EtGoodCode.setText("");
                EtGoodName.setText("");

            }
        });

        BtnGoodExit.setOnClickListener(new View.OnClickListener() {
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
