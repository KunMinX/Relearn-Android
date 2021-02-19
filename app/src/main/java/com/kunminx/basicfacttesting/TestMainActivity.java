package com.kunminx.basicfacttesting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.activity_lifecycle_and_recreate_test.OneActivity;
import com.kunminx.basicfacttesting.activity_intent_test.IntentTestActivity;
import com.kunminx.basicfacttesting.activity_task_test.StandardActivity_One;
import com.kunminx.basicfacttesting.fragment_test.jump.AddFragmentActivity;
import com.kunminx.basicfacttesting.animator_test.AnimatorListActivity;
import com.kunminx.basicfacttesting.jetpack_test.JetpackActivity;
import com.kunminx.basicfacttesting.service_test.TestServiceActivity;
import com.kunminx.basicfacttesting.touch_dispatch_test.TestDispatchActivity;
import com.kunminx.basicfacttesting.touch_nested_scroll_test.TestNestedScrollActivity;
import com.kunminx.basicfacttesting.window_test.TestWindowActivity;

public class TestMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

        Log.d("TAG", TestMainActivity.class.getSimpleName() + " -- taskId" + getTaskId());
    }

    public void testLifeCycle(View view) {
        startActivity(new Intent(this, OneActivity.class));
    }

    public void testDispatch(View view) {
        startActivity(new Intent(this, TestDispatchActivity.class));
    }

    public void testScroll(View view) {
        startActivity(new Intent(this, TestNestedScrollActivity.class));
    }

    public void testWindow(View view) {
        startActivity(new Intent(this, TestWindowActivity.class));
    }

    public void testIntent(View view) {
        startActivity(new Intent(this, IntentTestActivity.class));
    }

    public void testTask(View view) {
        startActivity(new Intent(this, StandardActivity_One.class));
    }

    public void testFragment(View view) {
        startActivity(new Intent(this, AddFragmentActivity.class));
    }

    public void testAnimator(View view) {
        startActivity(new Intent(this, AnimatorListActivity.class));
    }

    public void testService(View view) {
        startActivity(new Intent(this, TestServiceActivity.class));
    }

    public void testJetpack(View view) {
        startActivity(new Intent(this, JetpackActivity.class));
    }


}
