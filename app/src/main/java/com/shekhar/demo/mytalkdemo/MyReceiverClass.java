package com.shekhar.demo.mytalkdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chandrashekhar on 26/10/15.
 */
public class MyReceiverClass extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("my application", "WE ARE INSIDE!!!!!!!!!!!");

        Bundle bundle = intent.getExtras();
        String phoneNr= bundle.getString("incoming_number");

        if (phoneNr!=null && !phoneNr.isEmpty()){
            Toast.makeText(context,phoneNr,Toast.LENGTH_SHORT).show();

            Intent service = new Intent(context, TTSService.class);
            service.putExtra("number",phoneNr);
            context.startService(service);
        }
    }
}
