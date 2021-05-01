package com.kunminx.basicfacttesting.test_03_activity_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class IntentTestActivity extends AppCompatActivity {

    private Button
            mBtnTestImAty,//隐式启动
            mBtnTestExAty,//显式启动
            mBtnTestList,//隐式启动，弹出匹配的组件列表
            mBtnTestAction,//测试 ACTION 匹配
            mBtnTestCategory,//测试 Category 匹配
            mBtnTestData,//测试 Data 匹配
            mBtnTestInit,//测试携带数据
            mBtnTestCallback;//测试回调

    private static final int REQUEST_CODE = 1;


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

        mBtnTestInit = (Button) findViewById(R.id.btn_for_init_data);
        mBtnTestCallback = (Button) findViewById(R.id.btn_for_callback);

        mBtnTestExAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentTestActivity.this, IntentTestTwoActivity.class);
                startActivity(intent);
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
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "我是被发送的文本");
                intent.setType("text/plain");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        mBtnTestAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "我是被发送的文本");
                intent.setType("text/plain");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        mBtnTestCategory.setOnClickListener(new View.OnClickListener() {
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

        mBtnTestInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentTestActivity.this, IntentTestTwoActivity.class);
                intent.putExtra(IntentTestTwoActivity.INIT_DATA, 1);
                startActivity(intent);
            }
        });

        mBtnTestCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentTestActivity.this, IntentTestTwoActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                //此处拿到的 callbackData 会是 IntentTestTwoActivity 传过来的 123.
                int callbackData = data.getIntExtra(IntentTestTwoActivity.CALLBACK_DATA, 0);
                System.out.println(callbackData);
            }
        }
    }
}
