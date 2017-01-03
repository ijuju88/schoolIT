package com.example.it.dialogapplication;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Btn;
    ImageView Iv;
    TextView TvToast;
    View ToastView;

    String[] str={"젤리빈","킷캣", "롤리팝"};
    int[] ivarr={R.drawable.api43, R.drawable.api44, R.drawable.api50};
    int ivstr=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn=(Button)findViewById(R.id.btn);
        Iv=(ImageView)findViewById(R.id.iv);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dig=new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("좋아하는 안드로이드 버전은??");
               /* dig.setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Iv.setImageResource(ivarr[which]);
                                break;
                            case 1:
                                Iv.setImageResource(ivarr[which]);
                                break;
                            case 2:
                                Iv.setImageResource(ivarr[which]);
                                break;
                        }
                    }
                });*/

                dig.setSingleChoiceItems(str,0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ivstr=which;
                        Log.i("Log", String.valueOf(which));
                        }
                });

                //dig.setIcon(R.drawable.api40png);
                dig.setIcon(R.mipmap.ic_launcher); //기본아이콘
                //밑에 확인버튼 및 버튼누를때 할일
                //dig.setPositiveButton("확인",null);

                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       if(ivstr==10){
                           Iv.setImageResource(R.mipmap.ic_launcher);
                       }else{
                           Iv.setImageResource(ivarr[ivstr]);
                       }
                       Toast.makeText(MainActivity.this,ivarr[ivstr], Toast.LENGTH_SHORT ).show();

                    }
                });

                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast=new Toast(MainActivity.this);
                        ToastView=(View)View.inflate(MainActivity.this, R.layout.toast, null);
                        TvToast=(TextView) ToastView.findViewById(R.id.tvtoast);
                        TvToast.setText("취소하였습니다");
                        toast.setView(ToastView);
                        toast.show();

                    }
                });
                       dig.show();
            }
        });
    }
}
