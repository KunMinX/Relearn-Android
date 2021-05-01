package com.kunminx.relearn_android;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import com.kunminx.basicfacttesting.activity_task_test.BaseTaskActivity;


/**
 * Create by KunMinX at 2018/10/18
 */
public class AllowTaskReparent_Activity extends BaseTaskActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume " + className + " -- taskId：" + getTaskId() + " -- processId:" + Process.myPid());

    }
}