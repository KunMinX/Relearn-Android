package com.kunminx.basicfacttesting;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kunminx.basicfacttesting.databinding.ActivityMainBinding;
import com.kunminx.basicfacttesting.lifecycle_test.OneActivity;
import com.kunminx.basicfacttesting.touch_dispatch_test.TestDispatchActivity;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

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
    }

}
