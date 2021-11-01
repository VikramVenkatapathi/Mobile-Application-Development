package com.example.v1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.logging.Handler;

public class LoadDialog {
    Activity activity;
    AlertDialog dialog;
    int seconds;

    LoadDialog(Activity activity){
        this.activity=activity;
    }

    void openDialog(int seconds){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);

        LayoutInflater inflater=activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(false);

        dialog=builder.create();
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                closeDialog();
            }
        }).start();
    }

    void closeDialog(){
        dialog.dismiss();
    }
}
