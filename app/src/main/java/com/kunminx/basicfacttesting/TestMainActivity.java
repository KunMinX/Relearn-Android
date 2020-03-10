package com.kunminx.basicfacttesting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.test01_lifecycle_test.OneActivity;
import com.kunminx.basicfacttesting.test02_intent_test.IntentTestActivity;
import com.kunminx.basicfacttesting.test03_task_test.StandardOneActivity;
import com.kunminx.basicfacttesting.test04_fragment_test.jump.AddFragmentActivity;
import com.kunminx.basicfacttesting.test_animator.AnimatorListActivity;
import com.kunminx.basicfacttesting.test_jetpack.JetpackActivity;
import com.kunminx.basicfacttesting.test_service.TestServiceActivity;
import com.kunminx.basicfacttesting.touch_dispatch_test.TestDispatchActivity;
import com.kunminx.basicfacttesting.touch_nested_scroll_test.TestNestedScrollActivity;
import com.kunminx.basicfacttesting.window_test.TestWindowActivity;

public class TestMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
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
        startActivity(new Intent(this, StandardOneActivity.class));
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

   /* public void testStatus(View view) {
        startActivity(new Intent(this, StatusActivity.class));
    }*/


}
