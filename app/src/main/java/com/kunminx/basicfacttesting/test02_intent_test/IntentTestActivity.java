package com.kunminx.basicfacttesting.test02_intent_test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class IntentTestActivity extends AppCompatActivity {

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

        mBtnTestExAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntentTestActivity.this, IntentTestTwoActivity.class));
            }
        });

        mBtnTestImAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.kunminx.action.two");
                intent.addCategory("com.kunminx.category.two");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        mBtnTestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
//                intent.setDataAndType(Uri.parse("https://"), "image/*");
//                intent.setAction("android.intent.action.VIEW");
                intent.setType("*/*");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
//                    getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                }
            }
        });

        mBtnTestAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnTestCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnTestData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("https://www.baidu.com"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }

}
