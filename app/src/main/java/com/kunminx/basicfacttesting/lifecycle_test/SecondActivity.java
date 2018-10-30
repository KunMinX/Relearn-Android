package com.kunminx.basicfacttesting.lifecycle_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kunminx.basicfacttesting.R;


/**
 * @author KunMinX
 * @date 2018/10/12
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("info", "SecondActivity--onCreate()");
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("info", "SecondActivity--onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("info", "SecondActivity--onResumed()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("info", "SecondActivity--onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("info", "SecondActivity--onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("info", "SecondActivity--onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("info", "SecondActivity--onDestroy()");
    }
}
