package com.shekhar.demo.mytalkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button secondActivity,startService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("my application 1", "onCreate");

        secondActivity= (Button) findViewById(R.id.second_activity);
        startService= (Button) findViewById(R.id.start_service);

        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent service = new Intent(MainActivity.this, BackgroundService.class);
                startService(service);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my application 1", "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my application 1", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my application 1", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my application 1", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("my application 1", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my application 1", "onDestroy");
    }



}
