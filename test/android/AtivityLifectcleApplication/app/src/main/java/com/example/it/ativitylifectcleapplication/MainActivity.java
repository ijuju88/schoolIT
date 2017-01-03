package com.example.it.ativitylifectcleapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BtnStart;

    // 상태 저장에 사용됨
    public static final String PREF_ID="test1";
    public static final int ACTMODE= Activity.MODE_PRIVATE;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveCurrentState(); //현재상태저장
        Toast.makeText(getApplicationContext(), "onPause...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreFromSavedState(); //현재상태 복원
        Toast.makeText(getApplicationContext(), "onResume...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart...", Toast.LENGTH_SHORT).show();
    }

    //설정 ㅓㅇ보에 저장한 상태값을 읽어와서 복원
    protected void restoreFromSavedState(){
        SharedPreferences myPrefs=getSharedPreferences(PREF_ID, ACTMODE);
        if((myPrefs!=null) && myPrefs.contains("txtMsg")){
            String myData=myPrefs.getString("txtMsg", "");
            Toast.makeText(getApplicationContext(), "Restored > "+myData, Toast.LENGTH_SHORT).show();
        }
    }

    //상태 값을 설정정보에 저장
   protected void saveCurrentState(){
       SharedPreferences myPrefs=getSharedPreferences(PREF_ID, ACTMODE);
       SharedPreferences.Editor myEdit=myPrefs.edit();
       myEdit.putString("txtMsg","My name is ijuju.");
       myEdit.commit();
    }

    protected void clearMyPrefs(){
        SharedPreferences myPrefs=getSharedPreferences(PREF_ID, ACTMODE);
        SharedPreferences.Editor myEdit=myPrefs.edit();
        myEdit.clear();
        myEdit.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnStart=(Button)findViewById(R.id.btnstart);
        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
                Log.i("Loginfo", " SecondActivity클릭했습니당");
            }
        });


    }
}
