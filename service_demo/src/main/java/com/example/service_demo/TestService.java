package com.example.service_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.TextView;
import android.widget.Toast;

public class TestService extends Service {
    public TestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Toast.makeText(this, "service is started", Toast.LENGTH_SHORT).show();
        doSomething();
        return START_STICKY;//if system kills the service due to any reason then the system will attempt to restart it.
    }

    private void doSomething() {
        try{
            Thread.sleep(5000);
            TestNotification.notify(this,"task done",0);
        } catch (InterruptedException e) {
            Toast.makeText(this, "some error occured", Toast.LENGTH_SHORT).show();
        }
    }


}
