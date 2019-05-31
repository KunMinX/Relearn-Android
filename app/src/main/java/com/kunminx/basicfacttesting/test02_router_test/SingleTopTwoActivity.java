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
public class SingleTopTwoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnStandardTwo, mBtnSingleTopOne, mBtnStandardOne,
            mBtnSingleTaskTwo, mBtnSingleTaskOne, mBtnSingleTopTwo,
            mBtnSingleInstance;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_task);

        mBtnStandardOne = (Button) findViewById(R.id.btn_standard_one);
        mBtnStandardTwo = (Button) findViewById(R.id.btn_standard_two);
        mBtnSingleTopOne = (Button) findViewById(R.id.btn_singletop_one);
        mBtnSingleTopTwo = (Button) findViewById(R.id.btn_singletop_two);
        mBtnSingleTaskOne = (Button) findViewById(R.id.btn_singletask_one);
        mBtnSingleTaskTwo = (Button) findViewById(R.id.btn_singletask_two);
        mBtnSingleInstance = (Button) findViewById(R.id.btn_singleinstance);

        mBtnStandardTwo.setOnClickListener(this);
        mBtnSingleTopOne.setOnClickListener(this);
        mBtnStandardOne.setOnClickListener(this);
        mBtnSingleTaskTwo.setOnClickListener(this);
        mBtnSingleTaskOne.setOnClickListener(this);
        mBtnSingleTopTwo.setOnClickListener(this);
        mBtnSingleInstance.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_standard_one:
                startActivity(new Intent(this, StandardOneActivity.class));
                break;
            case R.id.btn_standard_two:
                startActivity(new Intent(this, StandardTwoActivity.class));
                break;
            case R.id.btn_singletop_one:
                startActivity(new Intent(this, SingleTaskOneActivity.class));
                break;
            case R.id.btn_singletop_two:
                startActivity(new Intent(this, SingleTopTwoActivity.class));
                break;
            case R.id.btn_singletask_one:
                startActivity(new Intent(this, SingleTaskOneActivity.class));
                break;
            case R.id.btn_singletask_two:
                startActivity(new Intent(this, SingleTopTwoActivity.class));
                break;
            case R.id.btn_singleinstance:
                startActivity(new Intent(this, SingleInstanceActivity.class));
                break;
            default:
        }
    }
}
