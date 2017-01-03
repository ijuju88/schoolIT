package com.example.it.dialog2application;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView TvName, TvEmail, TvToast;
    Button BtnOpen;
    EditText digName, digEmaii;
    View dialogView, toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvName=(TextView)findViewById(R.id.tvName);
        TvEmail=(TextView)findViewById(R.id.tvEmail);
        TvToast=(TextView)findViewById(R.id.tvtoast);
        BtnOpen=(Button)findViewById(R.id.btnopen);
        BtnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView=(View)View.inflate(MainActivity.this, R.layout.diguser, null);
                AlertDialog.Builder dig=new  AlertDialog.Builder(MainActivity.this);

                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.mipmap.ic_launcher);

                dig.setView(dialogView); //다이얼로그 내용
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                digName=(EditText)dialogView.findViewById(R.id.etName);
                                digEmaii=(EditText)dialogView.findViewById(R.id.etEmail);

                                TvName.setText(digName.getText().toString());
                                TvEmail.setText(digEmaii.getText().toString());
                            }
                        });
                        dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast toast=new Toast(MainActivity.this);
                                        toastView=(View)View.inflate(MainActivity.this, R.layout.toast, null);
                                        TvToast=(TextView) toastView.findViewById(R.id.tvtoast);
                                        TvToast.setText("취소하였습니다");
                                        toast.setView(toastView);
                                        toast.show();

                                    }
                                });

                                dig.show();
            }
        });
    }
}
