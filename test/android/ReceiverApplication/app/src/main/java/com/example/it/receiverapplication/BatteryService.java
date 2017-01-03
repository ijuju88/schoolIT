package com.example.it.receiverapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BatteryService extends Service {
    public BatteryService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
