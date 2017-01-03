package com.example.okjoo.calcuapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.*;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainCalcu extends AppCompatActivity implements View.OnClickListener {

    private Button[] but = new Button[10];
    private Button[] btn = new Button[8];
    private EditText edit, editResult;
    private int num1, num2;

    // 연산자를 기억하는 변수

    // no:무연산자 +:덧셈, -:뺄셈 *:곱셈 /:나눗셈, 초기값 0

    // 0:무연산자 1:덧셈, 2:뺄셈 3:곱셈 4:나눗셈, 초기값 0

    private String opstr;
    private int opcode;
    private GoogleApiClient client;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_calcu);

        // 에디트텍스트를 선언하고 객체참조 선언

        // 에디트텍스트창에 직접적인 입력을 막기위해 키 리스너 파라미터로 null값을 준다.

        edit = (EditText) findViewById(R.id.input);
        editResult = (EditText) findViewById(R.id.inputresult);

        edit.setKeyListener(null);
        editResult.setKeyListener(null);
        // 시작전 초기화

        clear();

        but[0] = (Button) findViewById(R.id.btn0);
        but[1] = (Button) findViewById(R.id.btn1);
        but[2] = (Button) findViewById(R.id.btn2);
        but[3] = (Button) findViewById(R.id.btn3);
        but[4] = (Button) findViewById(R.id.btn4);
        but[5] = (Button) findViewById(R.id.btn5);
        but[6] = (Button) findViewById(R.id.btn6);
        but[7] = (Button) findViewById(R.id.btn7);
        but[8] = (Button) findViewById(R.id.btn8);
        but[9] = (Button) findViewById(R.id.btn9);

        // OnClickListener선언

        for (int i = 0; i < 10; i++) {

            but[i].setTag(i);
            but[i].setOnClickListener(this);

        }

        // Initializing Operation Buttons

        btn[0] = (Button) findViewById(R.id.btnPlus);
        btn[1] = (Button) findViewById(R.id.btnMinus);
        btn[2] = (Button) findViewById(R.id.btnMutiply);
        btn[3] = (Button) findViewById(R.id.btnDivide);
        btn[4] = (Button) findViewById(R.id.btnC);
        btn[5] = (Button) findViewById(R.id.btnResult);
        btn[6] = (Button) findViewById(R.id.btnDel);
        btn[7] = (Button) findViewById(R.id.btnPlusMinus);

        // 숫자 버튼과 마찬가지로 루프문을 이용하여 OnClickListener선언

        for (int i = 0; i < 8; i++) {
            btn[i].setOnClickListener(this);
        }

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // 각 버튼의 클릭 이벤트 처리

    // 스위치문의 파라미터로 각 버튼의 고유한 id 를 받아서 처리

    // 연산버튼 클릭할 경우, 연속적인 계산 과정 중 중간 값을 보여주기 위해 getResult() 메서드를 호출하여 중간 값 출력

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnPlus:

                getResult();
                opcode = 1;
                opstr = "+";
                editResult.setText(Integer.toString(num1) + opstr);
                edit.setText("");
                break;
            case R.id.btnMinus:
                getResult();
                opcode = 2;
                opstr = "-";
                editResult.setText(Integer.toString(num1) + opstr);
                edit.setText("");
                break;

            case R.id.btnMutiply:
                getResult();
                opcode = 3;
                opstr = "*";
                editResult.setText(Integer.toString(num1) + opstr);
                edit.setText("");
                break;

            case R.id.btnDivide:
                getResult();
                opcode = 4;
                opstr = "/";
                editResult.setText(Integer.toString(num1) + opstr);
                edit.setText("");
                break;

            case R.id.btnPlusMinus:
                PlusMinus();
                break;

            case R.id.btnResult:
                getResult();
                break;

            case R.id.btnC:
                clear();
                break;

            case R.id.btnDel:
                del();
                break;

            default:

                if (opcode == 0) {
                    num1 = num1 * 10 + Integer.valueOf(v.getTag().toString());
                    edit.setText(Integer.toString(num1));

                } else {
                    num2 = num2 * 10 + Integer.valueOf(v.getTag().toString());
                    edit.setText(Integer.toString(num2));

                }

                break;

        }

    }

    private void PlusMinus() {
        int pm = 1;
        String strTemp = edit.getText().toString();
        if (pm == 1 && editResult.length() == 0) {
            edit.setText("-" + strTemp);
            num1 = Integer.parseInt("-" + strTemp);
            pm = 2;
        } else if (pm == 2 && editResult.length() == 0) {
            edit.setText(strTemp);
            num1 = Integer.parseInt(strTemp);
            pm = 1;
        } else if (pm == 1 && opcode != 0 && num2 != 0) {
            edit.setText("-" + strTemp);
            num2 = Integer.parseInt("-" + strTemp);
            pm = 2;
        } else if (pm == 2 && opcode != 0 && num2 != 0) {
            edit.setText(strTemp);
            num2 = Integer.parseInt(strTemp);
            pm = 1;
        }
    }

    private void del() {
        String strTemp = edit.getText().toString();
        int nLength = strTemp.length();

        if (editResult.length() == 0 && nLength > 1) {
            strTemp = strTemp.substring(0, nLength - 1);
            edit.setText(strTemp);
            num1 = Integer.parseInt(strTemp);
       }  else if (editResult.length() == 0 && nLength <= 1) {
            strTemp="0";
            edit.setText(strTemp);
            num1=Integer.parseInt(strTemp);
        }

        else if (opcode != 0 && num2 != 0 && nLength > 1) {
            strTemp = strTemp.substring(0, nLength - 1);
            edit.setText(strTemp);
            num2 = Integer.parseInt(strTemp);
        }else if (opcode != 0 && num2 != 0 && nLength <= 1) {
            strTemp = "0";
            edit.setText(strTemp);
            num2 = Integer.parseInt(strTemp);

        }
// else if (opcode != 0 && num2 != 0) {
//            edit.setText(strTemp.substring(0, strTemp.length() - 1));
//            num2 = Integer.parseInt(strTemp.substring(0, strTemp.length() - 1));
//            if (strTemp.length() == 0) {
//                num2 = 0;
//                edit.setText(Integer.toString(num2));
//            }
//        }
    }

    // 연산 결과 num1 에 저장하여

    // 새로운 입력값을 저장하는 num2 와의 연산에 사용한다.

    public void getResult() {

        if (opcode != 0 && num2 != 0) {

            // opcode 를 식별자로 이벤트처리
            // 1:덧셈 2:뺄셈 3:곱셈 4:나눗셈

            switch (opcode) {

                case 1:

                    num1 = num1 + num2;
                    edit.setText("=" + Integer.toString(num1));
                    num2 = 0;
                    break;

                case 2:

                    num1 = num1 - num2;
                    edit.setText("=" + Integer.toString(num1));
                    num2 = 0;
                    break;

                case 3:

                    num1 = num1 * num2;
                    edit.setText("=" + Integer.toString(num1));
                    num2 = 0;
                    break;

                case 4:

                    num1 = num1 / num2;
                    edit.setText("=" + Integer.toString(num1));
                    num2 = 0;
                    break;
            }

        }

    }


    public void clear() {

        num1 = 0;
        num2 = 0;
        opcode = 0;
        opstr = "";
        editResult.setText("");
        edit.setText(Integer.toString(num1));

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MainCalcu Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
