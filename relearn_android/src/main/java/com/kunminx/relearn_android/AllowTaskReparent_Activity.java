package com.kunminx.relearn_android;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import com.kunminx.basicfacttesting.test_02_activity_task.BaseTaskActivity;


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

        //TODO 在 onResume 节点来安排 log，以便能重新获取最新的 taskId
        // 具体详见《任务与返回栈篇》评论区 95 楼的解析 https://xiaozhuanlan.com/topic/7812045693

        Log.d(TAG, "onResume " + className + " -- taskId：" + getTaskId() + " -- processId:" + Process.myPid());

    }
}