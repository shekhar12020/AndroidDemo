package com.shekhar.demo.mytalkdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TTSService extends Service implements TextToSpeech.OnInitListener {

    private TextToSpeech mTts;
    private static final String TAG = "TTSService";
    private String text;

    @Override

    public IBinder onBind(Intent arg0) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "on create_service");
    }


    @Override
    public void onDestroy() {
        if (mTts != null) {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.getExtras()!=null){
            text=intent.getExtras().getString("number");
        }else{
            text="no data found.";
        }

        mTts = new TextToSpeech(this, this);
        mTts.setSpeechRate(1f);

        Log.v(TAG, "on start_service");


        return START_STICKY;
    }

    @Override
    public void onInit(int status) {

        Log.v(TAG, "on init");

        if (status == TextToSpeech.SUCCESS) {
            int result = mTts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.v(TAG, "Language is not available.");
            } else {
                sayHello(text);
            }
        } else {
            Log.v(TAG, "Could not initialize TextToSpeech.");
        }
    }

    public void sayHello(String str) {
        mTts.speak(str, TextToSpeech.QUEUE_FLUSH, null,null);
    }
}