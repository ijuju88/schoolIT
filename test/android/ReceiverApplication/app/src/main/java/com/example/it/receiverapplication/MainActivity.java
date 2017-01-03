package com.example.it.receiverapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView Iv;
    TextView TvBattery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Iv=(ImageView)findViewById(R.id.iv);
        TvBattery=(TextView)findViewById(R.id.tvbattery);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter ifilter=new IntentFilter();
        ifilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, ifilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }

    BroadcastReceiver br=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int remain=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            String action=intent.getAction();
            TvBattery.setText("현재충전량 > "+remain);

            if(action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                if (remain >= 90) {
                    Iv.setImageResource(R.drawable.battery_100);
                } else if (remain > 70) {
                    Iv.setImageResource(R.drawable.battery_80);
                } else if (remain > 50) {
                    Iv.setImageResource(R.drawable.battery_60);
                } else if (remain > 10) {
                    Iv.setImageResource(R.drawable.battery_20);
                }else{
                    Iv.setImageResource(R.drawable.battery_0);
                }

                int plug=intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (plug){
                    case 0:
                        TvBattery.append("전원연결완료");
                        break;

                    case BatteryManager.BATTERY_PLUGGED_AC:
                        TvBattery.append("전원연결 > 어뎁터연결됨");
                        break;

                    case BatteryManager.BATTERY_PLUGGED_USB:
                        TvBattery.append("전원연결 > USB연결됨");
                        break;
                }
            }

        }
    };
}
