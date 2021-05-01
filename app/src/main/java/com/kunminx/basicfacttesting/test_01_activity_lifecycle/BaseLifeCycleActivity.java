package com.kunminx.basicfacttesting.test_01_activity_lifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Create by KunMinX at 2018/10/12
 */
public class BaseLifeCycleActivity extends AppCompatActivity {

    protected String className = getClass().getSimpleName();
    protected static final String TAG = "info";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, className + "--onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, className + "--onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, className + "--onResumed()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, className + "--onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, className + "--onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, className + "--onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, className + "--onRestart()");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, className + "--onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, className + "--onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, className + "--onWindowFocusChanged()");
        super.onWindowFocusChanged(hasFocus);
    }

}
