package com.nusoft.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.util.Log;

public class NusoftScanner extends CordovaPlugin
{
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("scan"))
        {
            NusoftReceiver mReceiver = new NusoftReceiver(callbackContext);

            IntentFilter filter = new IntentFilter("com.neusoft.action.scanner.read");        
                
            cordova.getActivity().registerReceiver(mReceiver, filter);
            //sendBroadcast(mIntent);
            return true;
        } else {
            return false;
        }
    }
}