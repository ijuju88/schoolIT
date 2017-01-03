package com.example.it.test2application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button BtnCustomer, BtnSales, BtnGoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BtnCustomer=(Button)findViewById(R.id.btncustomer);
        BtnSales=(Button)findViewById(R.id.btnsales);
        BtnGoods=(Button)findViewById(R.id.btngoods);

        Intent receivedIntent = getIntent();
        final String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();

        BtnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customerIntent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(customerIntent);
            }
        });

        BtnGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goodsIntent = new Intent(getApplicationContext(), GoodsActivity.class);
                startActivity(goodsIntent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
