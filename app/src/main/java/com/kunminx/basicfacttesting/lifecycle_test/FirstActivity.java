package com.kunminx.basicfacttesting.lifecycle_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kunminx.basicfacttesting.R;


/**
 * @author KunMinX
 * @date 2018/10/12
 */
public class FirstActivity extends AppCompatActivity {

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("info", "----FirstActivity--onCreate()");
        setContentView(R.layout.activity_first);
        mCustomView = (CustomView) findViewById(R.id.custom_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("info", "----FirstActivity--onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("info", "----FirstActivity--onResumed()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("info", "----FirstActivity--onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("info", "----FirstActivity--onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("info", "----FirstActivity--onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("info", "----FirstActivity--onDestroy()");
    }
}
