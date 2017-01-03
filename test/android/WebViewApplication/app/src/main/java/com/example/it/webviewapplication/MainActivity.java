package com.example.it.webviewapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText EtWeb;
    Button BtnConnect;
    WebView WV;
    Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtWeb=(EditText)findViewById(R.id.etWeb);
        BtnConnect=(Button)findViewById(R.id.btnconnect);
        WV=(WebView)findViewById(R.id.wvconnect);

        WebSettings webSettings=WV.getSettings();
        webSettings.setJavaScriptEnabled(true); //javascript 씀
        WV.setWebChromeClient(new WebBrowserClient());
        WV.addJavascriptInterface(new JavaScriptMethod(),"sample");
        WV.loadUrl("file:///android_asset/www/sample.html");

        BtnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*WebSettings webSettings=WV.getSettings();
               /webSettings.setJavaScriptEnabled(true); //javascript 씀
                WV.loadUrl(EtWeb.getText().toString());*/
                String url=EtWeb.getText().toString();
               WV.loadUrl(url);
            }
        });
    }
    /*class Browser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            return super.shouldOverrideUrlLoading(view, request);
        }
    }*/

    final class JavaScriptMethod{
        JavaScriptMethod(){};

        @android.webkit.JavascriptInterface
        public void clickOnFace(){
           mHandler.post(new Runnable() {
               @Override
               public void run() {
                   BtnConnect.setText("클릭후 열기");
                   WV.loadUrl("javascript:changeFace()");
               }
           });
        }
    }

    final class WebBrowserClient extends WebChromeClient{

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            //return super.onJsAlert(view, url, message, result);
            result.confirm();
            return true;
        }

    }
}
