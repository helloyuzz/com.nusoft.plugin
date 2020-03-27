package com.nusoft.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.util.Log;

public class NusoftReceiver extends BroadcastReceiver
{
    private CallbackContext callbackContext;

    public NusoftReceiver (CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String barcode = intent.getStringExtra("scanner_value");
     
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, barcode);

        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);

        //callbackContext.success(barcode);
    }
}