package com.kunminx.basicfacttesting;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.databinding.ActivityMainBinding;
import com.kunminx.basicfacttesting.test01_lifecycle_test.OneActivity;
import com.kunminx.basicfacttesting.test02_intent_test.IntentTestActivity;
import com.kunminx.basicfacttesting.test03_task_test.StandardOneActivity;
import com.kunminx.basicfacttesting.touch_dispatch_test.TestDispatchActivity;
import com.kunminx.basicfacttesting.window_test.TestWindowActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setClick(new ClickProxy());

//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
    }

    public native String stringFromJNI();

    public class ClickProxy {

        public void testLifeCycle() {
            startActivity(new Intent(MainActivity.this, OneActivity.class));
        }

        public void testDispatch() {
            startActivity(new Intent(MainActivity.this, TestDispatchActivity.class));
        }

        public void testWindow() {
            startActivity(new Intent(MainActivity.this, TestWindowActivity.class));
        }

        public void testIntent(){
            startActivity(new Intent(MainActivity.this, IntentTestActivity.class));
        }

        public void testTask(){
            startActivity(new Intent(MainActivity.this, StandardOneActivity.class));
        }
    }

}
