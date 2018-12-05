package com.kunminx.basicfacttesting.lifecycle_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class OneActivity extends AppCompatActivity {

    private static final String TAG = "------OneActivity";


    private Button mBtnJumpAty, mBtnJumpFrg, mBtnShowDlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnJumpAty = (Button) findViewById(R.id.btn_jump_aty);
        mBtnJumpFrg = (Button) findViewById(R.id.btn_jump_frg);
        mBtnShowDlg = (Button) findViewById(R.id.btn_show_dlg);
        mBtnJumpAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OneActivity.this, SecondActivity.class));
            }
        });
        mBtnJumpFrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frg_container, new OneFragment())
                        .addToBackStack(null).commit();
            }
        });
        mBtnShowDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frg_container_1, new OneAutoFragment())
                .addToBackStack(null).commit();
    }

    public void showDialog() {
        new AlertDialog.Builder(this).setTitle("xxx").create().show();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu");
//        getMenuInflater().inflate(R.menu.test_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
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
    }

}
