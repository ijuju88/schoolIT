package com.example.it.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service implements Runnable{
    //로그캣에서 tag 사용할겁니다
    public static final String TAG="LogService";
    private int count =0;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread thread=new Thread(this);
        thread.start();
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void run() {
        while (true){
            try {
                if(count<100){
                    Log.i(TAG, "My Service called #"+count);
                    count++;
                    Thread.sleep(500);
                }
            }catch (Exception e){
                Log.e(TAG,e.toString());
            }
        }
    }
}
