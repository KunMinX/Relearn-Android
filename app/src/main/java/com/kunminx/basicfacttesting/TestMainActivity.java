package com.kunminx.basicfacttesting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.test_01_activity_lifecycle.OneActivity;
import com.kunminx.basicfacttesting.test_03_activity_intent.IntentTestActivity;
import com.kunminx.basicfacttesting.test_02_activity_task.StandardActivity_One;
import com.kunminx.basicfacttesting.test_04_fragment.jump.AddFragmentActivity;
import com.kunminx.basicfacttesting.test_09_animator.AnimatorListActivity;
import com.kunminx.basicfacttesting.test_05_jetpack.JetpackActivity;
import com.kunminx.basicfacttesting.test_10_service.TestServiceActivity;
import com.kunminx.basicfacttesting.test_06_touch_dispatch.TestDispatchActivity;
import com.kunminx.basicfacttesting.test_07_touch_nested_scroll.TestNestedScrollActivity;
import com.kunminx.basicfacttesting.test_08_window.TestWindowActivity;

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
