package com.kunminx.basicfacttesting.test01_lifecycle_test;

import android.os.Bundle;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/12
 */
public class SecondActivity extends BaseLifeCycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


}
