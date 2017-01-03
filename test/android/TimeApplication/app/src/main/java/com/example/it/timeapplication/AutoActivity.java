package com.example.it.timeapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * Created by it on 2017-01-02.
 */

public class AutoActivity extends AppCompatActivity {
    AutoCompleteTextView Actv;
    MultiAutoCompleteTextView Mactv;
    String []items={"CSI","Friends","Fringe","Lost"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autotext_activity);

        Actv=(AutoCompleteTextView)findViewById(R.id.actv);
        Mactv=(MultiAutoCompleteTextView) findViewById(R.id.mactv);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, items);

        Actv.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer tokenizer=new
                MultiAutoCompleteTextView.CommaTokenizer();

        Mactv.setTokenizer(tokenizer);
        Mactv.setAdapter(adapter);

    }
}
