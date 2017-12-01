package com.ipedge.changerfid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/**
 * This class writes an EPC to an RFID tag
 */
public class EPCWriter extends CordovaPlugin {

    /* Constants */
    public static final String SM_BCAST_SCAN = "com.restock.serialmagic.gears.action.SCAN";
    public static final String SM_BCAST_STATE_REPLY = "com.restock.serialmagic.gears.action.STATEREPLY";
    public static final String SM_BCAST_APP_STATE_QUERY = "com.restock.mobilelist.action.STATEQUERY";
    public static final String SM_BCAST_APP_STATE_REPLY = "com.restock.mobilelist.action.STATEREPLY";
    public static final String SM_BCAST_FOCUS = "com.restock.serialmagic.gears.action.FOCUS";
    public static final String SM_BCAST_CONNECTION = "com.restock.serialmagic.gears.action.CONNECTION";

    public static final String SM_BCAST_WRITEEPC = "com.restock.serialmagic.gears.action.WRITEEPC";
    public static final String SM_BCAST_WRITEEPC_RESPONSE = "com.restock.serialmagic.gears.action.WRITEEPC_RESPONSE";
    /* Variables */
    private ContextWrapper contextWrapper;
    private CallbackContext callbackContext;
    private BroadcastReceiver receiver;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		        if (action.equals("writeEPC")) {
						String message = args.getString(0);
            if (message == null || message.length() == 0) return false;

            this.callbackContext = callbackContext;
            setup();
			writeEPC(message);
			return true;
        }
        return false;
    }

    private void setup(){
        contextWrapper = new ContextWrapper(this.cordova.getActivity().getApplicationContext());

        // create and register the broadcast receiver
        IntentFilter filter = new IntentFilter(SM_BCAST_SCAN);
        filter.addAction(SM_BCAST_STATE_REPLY);
        filter.addAction(SM_BCAST_APP_STATE_REPLY);
        filter.addAction(SM_BCAST_APP_STATE_QUERY);
        filter.addAction(SM_BCAST_FOCUS);
        filter.addAction(SM_BCAST_CONNECTION);
        filter.addAction(SM_BCAST_WRITEEPC_RESPONSE);

        receiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                String s = intent.getAction();
                if(s.equals(SM_BCAST_WRITEEPC_RESPONSE)) {
                    if (callbackContext != null){
                        Boolean success = intent.getBooleanExtra("result", false);

                        if (success){
                            callbackContext.success();
                        } else {
                            callbackContext.error("Failed to write to tag");
                        }

                        contextWrapper.unregisterReceiver(receiver);
                        callbackContext = null;
                    }
                }
            }
        };

        contextWrapper.registerReceiver(receiver, filter);
    } 

   private void writeEPC(String message) {
        Intent reg = new Intent(SM_BCAST_WRITEEPC);
        String strEPC = message;
        reg.putExtra("epc", strEPC);

        contextWrapper.sendBroadcast(reg);
    }
}