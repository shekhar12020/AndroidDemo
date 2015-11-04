package com.shekhar.demo.mytalkdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chandrashekhar on 26/10/15.
 */
public class BackgroundService extends Service {
    private static final String TAG = "My Service Demo";
    MediaPlayer myPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "My Service Created", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");

        myPlayer = MediaPlayer.create(this, R.raw.music);
        myPlayer.setLooping(false); // Set looping
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "My Service Started", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
        myPlayer.start();

        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "My Service Stopped", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
        myPlayer.stop();
    }

}

