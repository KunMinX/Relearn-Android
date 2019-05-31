package com.kunminx.basicfacttesting.test03_task_test;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Create by KunMinX at 2018/10/12
 */
public class BaseTaskActivity extends AppCompatActivity {

    protected String className = getClass().getSimpleName();
    protected static final String TAG = "info";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, className + " -- taskId：" + getTaskId());
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, className + "--onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, className + "--onResumed()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, className + "--onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, className + "--onStop()");
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, className + " --销毁");
    }

    /*@Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, className + "--onRestart()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "onRestoreInstanceState");
        super.onWindowFocusChanged(hasFocus);
    }*/

}
