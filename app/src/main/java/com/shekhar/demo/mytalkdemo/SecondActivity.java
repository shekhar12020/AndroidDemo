package com.shekhar.demo.mytalkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by chandrashekhar on 26/10/15.
 */
public class SecondActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("my application", "onCreate");
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my application", "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my application", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my application", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my application", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("my application", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my application", "onDestroy");
    }
}
