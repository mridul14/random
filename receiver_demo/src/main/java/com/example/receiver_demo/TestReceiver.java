package com.example.receiver_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action=intent.getAction();
        if(action.equals(AudioManager.ACTION_HEADSET_PLUG)){
            //show notification
            //or something else
            TestNotification.notify(context,"headset plugged In/Out");
        }
        if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
            //launch activity or service
            //most app has services that start on device boot
            TestNotification.notify(context,"App Started");
        }
    }
}
