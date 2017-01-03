package com.example.it.menutext2application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText EtRotate;
    ImageView Iv;
    MenuItem And43, And44, And50;
    int rot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtRotate = (EditText) findViewById(R.id.etrotate);
        Iv = (ImageView) findViewById(R.id.imageView);
        And43=(MenuItem)findViewById(R.id.and43);
        And44=(MenuItem)findViewById(R.id.and44);
        And50=(MenuItem)findViewById(R.id.and50);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.rotate:
                rot = Integer.parseInt(EtRotate.getText().toString());
                Log.d("Log",EtRotate.getText().toString());
                if (rot <= 360) {
                    Iv.setRotation(rot);
                } else {
                    Toast.makeText(getApplicationContext(), "360도이상안됨", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.and43:
                Iv.setImageResource(R.drawable.api43);
                item.setChecked(true);
                return true;

            case R.id.and44:
                Iv.setImageResource(R.drawable.api44);
                item.setChecked(true);
                return true;

            case R.id.and50:
                Iv.setImageResource(R.drawable.api50);
                item.setChecked(true);
                return true;

        }
        return false;
    }
}
