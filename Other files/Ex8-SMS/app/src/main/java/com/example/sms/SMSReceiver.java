package com.example.sms;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    private static final String TAG = SMSReceiver.class.getSimpleName();
    public static final String pdu_type = "pdus";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs;
        String strMessage = "";
        String format = bundle.getString("format");

        Object[] pdus = (Object[]) bundle.get(pdu_type);
        if(pdus != null){
            boolean isVersion = (Build.VERSION.SDK_INT > Build.VERSION_CODES.M);

            msgs = new SmsMessage[pdus.length];
            for (int i=0;i< pdus.length;i++){
                if(isVersion){
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                }
                else{
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                strMessage += "Message from " + msgs[i].getOriginatingAddress();
                strMessage += ":" + msgs[i].getMessageBody() + "\n";

                Log.d(TAG, "onReceive: "+strMessage);
                Toast.makeText(context, strMessage,Toast.LENGTH_LONG).show();
            }
        }

    }
}