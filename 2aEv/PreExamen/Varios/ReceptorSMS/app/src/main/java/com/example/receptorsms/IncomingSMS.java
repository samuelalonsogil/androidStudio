package com.example.receptorsms;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;

public class IncomingSMS extends BroadcastReceiver {

    TextView textViewPhoneNumber, textViewMessage;

    // Get the object of SmsManager PROBABLEMENTE NO NECESARIO
    final SmsManager sms = SmsManager.getDefault();

    public IncomingSMS(Activity activity) {
        textViewPhoneNumber = activity.findViewById(R.id.senderNum);
        textViewMessage = activity.findViewById(R.id.message);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
        final String format = bundle.getString("format");
        try {
            final Object[] pdusObj = (Object[]) bundle.get("pdus");
            for (Object pdu : pdusObj) {
                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdu, format);
                String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                String message = currentMessage.getDisplayMessageBody();
                Log.i("SMSReceiver", "senderNum: " + phoneNumber + "; message: " + message);
                textViewPhoneNumber.setText(phoneNumber);
                textViewMessage.setText(message);
            }

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }
}
