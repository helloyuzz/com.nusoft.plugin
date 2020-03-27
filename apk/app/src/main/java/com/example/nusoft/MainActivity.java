package com.example.nusoft;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.BroadcastReceiver;


public class MainActivity extends AppCompatActivity {
    private String TAG = "BCRSample";

    private Handler mHandler = new Handler();
    private Button scanView = null;
    private Button stopView = null;
    private TextView mResultView = null;
    private int mTimes = 1;
    private String resultText = "";
    private static final String ACTION_BARCODE_READER_VALUE = "com.neusoft.action.scanner.read";
    private static final String BORCODE_VALUE = "scanner_value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mResultView = (TextView) findViewById(R.id.tbx_text);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Intent mIntent = new Intent("com.neusoft.action.scanner.start");
//        Log.d(TAG, "com.neusoft.action.scanner.start");
//        sendBroadcast(mIntent);

        registerBoradcastReceiver();
    }
    public void registerBoradcastReceiver(){
        Log.d(TAG,"====registerBoradcastReceiver====----------cclu====");
        IntentFilter myIntentFilter = new IntentFilter("com.neusoft.action.scanner.read");
        //myIntentFilter.addAction("aa");
        registerReceiver(mBarcodeReaderReceiver, myIntentFilter);
    }

    private BroadcastReceiver mBarcodeReaderReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG,"====BarcodeReaderActivity=====ACTION===="+action);
            if(action.equals(ACTION_BARCODE_READER_VALUE)){
                resultText = intent.getStringExtra(BORCODE_VALUE);
                mResultView.setText(resultText);
            }
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        finish();
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    private void doScan() {
        Log.d(TAG,"scan");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
