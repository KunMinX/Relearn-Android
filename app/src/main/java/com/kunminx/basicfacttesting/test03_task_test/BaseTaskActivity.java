package com.kunminx.basicfacttesting.test03_task_test;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
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
    protected static final String TAG = "TAG";

    protected Button mBtnStandardOne, mBtnStandardTwo, mBtnSingleTopOne, mBtnClearTop,
            mBtnSingleTaskA, mBtnSingleTaskB, mBtnSingleTaskC, mBtnSingleTaskD,
            mBtnSingleTaskG, mBtnSingleTaskH,
            mBtnStandardI, mBtnSingleTopJ, mBtnClearTopA, mBtnSingleInstance,
            mBtnFlagNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, className + " -- taskId：" + getTaskId() + " -- processId:" + Process.myPid());

        setContentView(R.layout.activity_test_task);

        mBtnStandardOne = (Button) findViewById(R.id.btn_standard_one);
        mBtnStandardTwo = (Button) findViewById(R.id.btn_standard_two);
        mBtnSingleTopOne = (Button) findViewById(R.id.btn_singletop_one);
        mBtnClearTop = (Button) findViewById(R.id.btn_clear_top);
        mBtnSingleTaskA = (Button) findViewById(R.id.btn_singletask_a);
        mBtnSingleTaskB = (Button) findViewById(R.id.btn_singletask_b);
        mBtnSingleTaskC = (Button) findViewById(R.id.btn_singletask_c);
        mBtnSingleTaskD = (Button) findViewById(R.id.btn_singletask_d);
        mBtnSingleTaskG = (Button) findViewById(R.id.btn_singletask_g);
        mBtnSingleTaskH = (Button) findViewById(R.id.btn_singletask_h);
        mBtnStandardI = (Button) findViewById(R.id.btn_standard_i);
        mBtnSingleTopJ = (Button) findViewById(R.id.btn_singletop_j);
        mBtnClearTopA = (Button) findViewById(R.id.btn_clear_top_a);
        mBtnSingleInstance = (Button) findViewById(R.id.btn_singleinstance);
        mBtnFlagNewTask = (Button) findViewById(R.id.btn_flag_new_task);

        mBtnStandardOne.setOnClickListener(this);
        mBtnStandardTwo.setOnClickListener(this);
        mBtnSingleTopOne.setOnClickListener(this);
        mBtnClearTop.setOnClickListener(this);
        mBtnSingleTaskA.setOnClickListener(this);
        mBtnSingleTaskB.setOnClickListener(this);
        mBtnSingleTaskC.setOnClickListener(this);
        mBtnSingleTaskD.setOnClickListener(this);
        mBtnSingleTaskG.setOnClickListener(this);
        mBtnSingleTaskH.setOnClickListener(this);
        mBtnStandardI.setOnClickListener(this);
        mBtnSingleTopJ.setOnClickListener(this);
        mBtnClearTopA.setOnClickListener(this);
        mBtnSingleInstance.setOnClickListener(this);
        mBtnFlagNewTask.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, className + " onNewIntent -- taskId：" + getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, className + " -- 销毁");
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_standard_one) {
            Intent intent = new Intent(this, StandardActivity_One.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_standard_two) {
            Intent intent = new Intent(this, StandardActivity_Two.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletop_one) {
            Intent intent = new Intent(this, SingleTopActivity.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_clear_top) {
            Intent intent = new Intent(this, ClearTopActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_a) {
            Intent intent = new Intent(this, SingleTaskActivity_A.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_b) {
            Intent intent = new Intent(this, SingleTaskActivity_B.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_c) {
            Intent intent = new Intent(this, SingleTaskActivity_C.class);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_d) {
            Intent intent = new Intent(this, SingleTaskActivity_D.class);
            startActivityWithCheck(intent);

            //以下测试结果证实：
            //1.在 App2 中启动 App1 的 standard Activity，仍然遵守 standard 的特点：在启动它的 Activity 所在的任务中启动，也即跟随 App2。
            //2.在 App2 中启动 App1 的 singleTop Activity，跟随状况同 standard。
            //3.在 App2 中启动 App1 的 singleTask Activity，仍然处于 App1 的任务中，并不跟随 App2。
        } else if (i == R.id.btn_singletask_g) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.SingleTaskActivity_G");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletask_h) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.SingleTaskActivity_H");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_standard_i) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.StandardActivity_I");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_singletop_j) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.SingleTopActivity_J");
            intent.setComponent(name);
            startActivityWithCheck(intent);

        } else if (i == R.id.btn_clear_top_a) {
            Intent intent = new Intent();
            ComponentName name = new ComponentName(
                    "com.kunminx.relearn_android",
                    "com.kunminx.relearn_android.ClearTopAActivity");
            intent.setComponent(name);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
