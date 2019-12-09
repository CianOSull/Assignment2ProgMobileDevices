package com.example.assignment2.Intentservice;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.assignment2.R;

import static com.example.assignment2.Intentservice.App.CHANNEL_ID;

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    private PowerManager.WakeLock wakeLock;

    public MyIntentService() {
        super("MyIntentService");
        setIntentRedelivery(true);
    }

    public void onCreate(){
        super.onCreate();;
        Log.d(TAG, "onCreate");

        PowerManager powerManager = (PowerManager) getSystemService((POWER_SERVICE));
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "IntentService:WakeLock");
        wakeLock.acquire(600000);
        Log.d(TAG, "WakeLock Acquired");

        if (android.os.Build.VERSION_CODES.O <= android.os.Build.VERSION.SDK_INT) {
            Notification notification = new Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("Showing background services")
                    .setContentText("Running until finished")
                    .setSmallIcon(R.drawable.ic_android)
                    .build();

            startForeground(1, notification);
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");

        String input = intent.getStringExtra("inputExtra");

        for(int i = 0; i < 10; i++){
            Log.d(TAG, input + " - " + i);

            // This freezes it to make the log go slower
            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestory");

        wakeLock.release();
        Log.d(TAG, "WakeLock Released");
    }
}
