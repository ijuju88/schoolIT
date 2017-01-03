package com.example.it.test2application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private String id="test1", pw="1234"; //아이디 비번 - DB연동을 안해놔서
    public static final int REQUEST_CODE_MENU = 1001;

    private EditText EtId, EtPw;
    private Button BtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtId=(EditText)findViewById(R.id.etid);
        EtPw=(EditText)findViewById(R.id.etpw);

        BtnLogin=(Button)findViewById(R.id.btnlogin);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultid=EtId.getText().toString();
                String resultpw=EtPw.getText().toString();


               if(resultid.equals(id) && resultpw.equals(pw)){
                    Intent intentmenu= new Intent(getApplicationContext(), MenuActivity.class);
                    intentmenu.putExtra("username", resultid);
                    intentmenu.putExtra("password", resultpw);
                    startActivityForResult(intentmenu, REQUEST_CODE_MENU);
                }else
                    Toast.makeText(getApplicationContext(), "아이디나 비번이 잘못되었습니다", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==REQUEST_CODE_MENU){
            String menu = data.getStringExtra("menu");
            String message = data.getStringExtra("message");

            Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
