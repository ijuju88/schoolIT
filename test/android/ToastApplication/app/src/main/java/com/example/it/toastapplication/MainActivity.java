package com.example.it.toastapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BtnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnToast=(Button)findViewById(R.id.btnToast);
        BtnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View vToast = inflater.inflate(R.layout.toastborder, null);
                toast.setView(vToast);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
