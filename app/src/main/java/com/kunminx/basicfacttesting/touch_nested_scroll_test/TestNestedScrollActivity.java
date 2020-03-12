package com.kunminx.basicfacttesting.touch_nested_scroll_test;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;

/**
 * @author xmj
 * @date 2020/3/10
 */
public class TestNestedScrollActivity extends AppCompatActivity {

    private ScrollLinearLayout mLL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_nested_scroll);

        mLL = findViewById(R.id.ll);

    }
}
