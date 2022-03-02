package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receptor extends BroadcastReceiver {

    private final String SMS_RECEIVED="android.provider.Telephony.SMS_RECEIVED";


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED))
            Toast.makeText(context, "Recibido SMS", Toast.LENGTH_LONG).show();
    }
}
