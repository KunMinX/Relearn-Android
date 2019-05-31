package com.kunminx.basicfacttesting.test02_router_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.test01_lifecycle_test.SecondActivity;


/**
 * Create by KunMinX at 2018/10/18
 */
public class IntentTestTwoActivity extends AppCompatActivity {

    private Button mBtnTestImAty, mBtnTestList, mBtnTestExAty, mBtnTestData, mBtnTestCategory, mBtnTestAction;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent);
        mBtnTestExAty = (Button) findViewById(R.id.btn_explicitly_aty);
        mBtnTestImAty = (Button) findViewById(R.id.btn_implicitly_aty);
        mBtnTestList = (Button) findViewById(R.id.btn_implicitly_list);

        mBtnTestAction = (Button) findViewById(R.id.btn_implicitly_action);
        mBtnTestCategory = (Button) findViewById(R.id.btn_implicitly_category);
        mBtnTestData = (Button) findViewById(R.id.btn_implicitly_data);

        mBtnTestImAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntentTestTwoActivity.this, SecondActivity.class));
            }
        });

        mBtnTestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnTestExAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        
        mBtnTestData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnTestCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnTestAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
