package com.example.v4;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();

        PendingIntent pd = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, " Wake up ");

        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentIntent(pd);
        builder.setContentTitle("Alarm");
        builder.setContentText("Time up");

        NotificationManager notifmgr = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notifmgr.notify(1, builder.build());
    }
}