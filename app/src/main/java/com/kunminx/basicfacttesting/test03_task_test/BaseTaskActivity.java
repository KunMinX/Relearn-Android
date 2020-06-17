package com.kunminx.basicfacttesting.test03_task_test;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/12
 */
public class BaseTaskActivity extends AppCompatActivity implements View.OnClickListener {

    protected String className = getClass().getSimpleName();
    protected static final String TAG = "info";

    protected Button mBtnStandardOne, mBtnStandardTwo, mBtnSingleTopOne, mBtnClearTop,
            mBtnSingleTaskOne, mBtnSingleTaskTwo, mBtnSingleTaskA, mBtnSingleTaskB,
            mBtnStandardA, mBtnSingleTopA, mBtnClearTopA, mBtnSingleInstance,
            mBtnFlagNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, className + " -- taskId：" + getTaskId());

        setContentView(R.layout.activity_test_task);

        mBtnStandardOne = (Button) findViewById(R.id.btn_standard_one);
        mBtnStandardTwo = (Button) findViewById(R.id.btn_standard_two);
        mBtnSingleTopOne = (Button) findViewById(R.id.btn_singletop_one);
        mBtnClearTop = (Button) findViewById(R.id.btn_clear_top);
        mBtnSingleTaskOne = (Button) findViewById(R.id.btn_singletask_one);
        mBtnSingleTaskTwo = (Button) findViewById(R.id.btn_singletask_two);
        mBtnSingleTaskA = (Button) findViewById(R.id.btn_singletask_a);
        mBtnSingleTaskB = (Button) findViewById(R.id.btn_singletask_b);
        mBtnStandardA = (Button) findViewById(R.id.btn_standard_a);
        mBtnSingleTopA = (Button) findViewById(R.id.btn_singletop_a);
        mBtnClearTopA = (Button) findViewById(R.id.btn_clear_top_a);
        mBtnSingleInstance = (Button) findViewById(R.id.btn_singleinstance);
        mBtnFlagNewTask = (Button) findViewById(R.id.btn_flag_new_task);

        mBtnStandardOne.setOnClickListener(this);
        mBtnStandardTwo.setOnClickListener(this);
        mBtnSingleTopOne.setOnClickListener(this);
        mBtnClearTop.setOnClickListener(this);
        mBtnSingleTaskOne.setOnClickListener(this);
        mBtnSingleTaskTwo.setOnClickListener(this);
        mBtnSingleTaskA.setOnClickListener(this);
        mBtnSingleTaskB.setOnClickListener(this);
        mBtnStandardA.setOnClickListener(this);
        mBtnSingleTopA.setOnClickListener(this);
        mBtnClearTopA.setOnClickListener(this);
        mBtnSingleInstance.setOnClickListener(this);
        mBtnFlagNewTask.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, className + " onNewIntent -- taskId：" + getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, className + " --销毁");
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_standard_one) {
            Intent intent = new Intent(this, StandardActivity_A.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_standard_two) {
            Intent intent = new Intent(this, StandardActivity_B.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletop_one) {
            Intent intent = new Intent(this, SingleTopActivity.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_clear_top) {
            Intent intent = new Intent(this, ClearTopActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_one) {
            Intent intent = new Intent(this, SingleTaskActivity_C.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_two) {
            Intent intent = new Intent(this, SingleTaskActivity_D.class);
            startActivityWithCheck(intent);

            //以下测试结果证实：
            //1.在 App2 中启动 App1 的 standard Activity，仍然遵守 standard 的特点：在启动它的 Activity 所在的任务中启动，也即跟随 App2。
            //2.在 App2 中启动 App1 的 singleTop Activity，跟随状况同 standard。
            //3.在 App2 中启动 App1 的 singleTask Activity，仍然处于 App1 的任务中，并不跟随 App2。
        } else if (i == R.id.btn_singletask_a) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.SingleTaskAActivity");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_b) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.SingleTaskBActivity");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_standard_a) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.StandardAActivity");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletop_a) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.SingleTopAActivity");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_clear_top_a) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.ClearTopAActivity");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singleinstance) {
            Intent intent = new Intent(this, SingleInstanceActivity.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_flag_new_task) {
            Intent intent = new Intent(this, FlagNewTaskActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityWithCheck(intent);
        }
    }

    private void startActivityWithCheck(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
