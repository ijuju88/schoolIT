package com.example.it.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText Num1, Num2;
    RadioGroup RG;
    RadioButton Rbtot, Rbdel, Rbmul, Rbdiv;
    Button Btnadd;
    String opcode="";

    //만드는 방법 Code>Override Methods
    //창이 여러개일때 사용합니다.
    /*requestCode는 startActivityForResult()메서드로 실행 할때,
    우리가 넘겼던 두번째 인자값이 해당 requestCode로 반환됩니다.
    즉, requestCode를 잘 구분한다면 한 Activity에서 여러 Activity를 통해 결과를
    받아올 수 있다는 말이 될 수도 있고, 한 Activity에서 결과를 requestCode에 따라 분기처리하여
    로직을 구성할 수 있다는 말이 될 것 같습니다.

    resultCode는 결과의 성공여부를 알 수 있는 코드입니다.
    결과코드가 무조건 성공이면 좋지만 그렇지도 않은가 봐요. 대표적인 결과코드에 대한 상수로는
    RESULT_OK, RESULT_CANCELED가 있고, 해당 코드값 이외에 Custom한 RESULT_CODE를 만들어 전달하고 받을 수
    있을 것 같습니다.

    Intent 객체 즉 data라는 인자로 내려오는 값은 말 그대로 Intent값이 내려옵니다.*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode==RESULT_OK){
           int hap=data.getIntExtra("Hap", 0);
           Toast.makeText(getApplicationContext(), "결과 > "+hap,Toast.LENGTH_SHORT).show();
       }
        //super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText) findViewById(R.id.etnum1);
        Num2 = (EditText) findViewById(R.id.etnum2);

        RG=(RadioGroup)findViewById(R.id.rg);
        Rbtot=(RadioButton) findViewById(R.id.rbadd);
        Rbdel=(RadioButton) findViewById(R.id.rbdel);
        Rbmul=(RadioButton) findViewById(R.id.rbmul);
        Rbdiv=(RadioButton) findViewById(R.id.rbdiv);

        Btnadd = (Button) findViewById(R.id.btntot);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(Rbtot.isChecked()){
                    opcode="+";
                }else if(Rbdel.isChecked()){
                    opcode="-";
                }else if(Rbmul.isChecked()){
                    opcode="*";
                }else if(Rbdiv.isChecked()){
                    opcode="/";
                }else
                {
                    Toast.makeText(getApplicationContext(), "연산자선택안함", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                intent.putExtra("Num1", Integer.parseInt(Num1.getText().toString()));
                intent.putExtra("Opcode", opcode);
                intent.putExtra("Num2", Integer.parseInt(Num2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });


    }
}
