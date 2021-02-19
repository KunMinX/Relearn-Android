package com.kunminx.basicfacttesting.activity_intent_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.activity_lifecycle_and_recreate_test.SecondActivity;


/**
 * Create by KunMinX at 2018/10/18
 */
public class IntentTestTwoActivity extends AppCompatActivity {

    private Button mBtnTestImAty, mBtnTestList, mBtnTestExAty, mBtnTestData, mBtnTestCategory, mBtnTestAction;

    public static final String INIT_DATA = "INIT_DATA";
    public static final String CALLBACK_DATA = "CALLBACK_DATA";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intent);

        Intent intent = getIntent();

        //此处拿到的 initData 会是 IntentTestActivity 传过来的 1.
        int initData = intent.getIntExtra(INIT_DATA, 0);

        System.out.println(initData);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra(CALLBACK_DATA, 123);
        setResult(RESULT_OK, intent);
        finish();
    }
}
