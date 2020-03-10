package com.kunminx.basicfacttesting.touch_nested_scroll_test;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;

/**
 * @author xmj
 * @date 2020/3/10
 */
public class TestNestedScrollActivity extends AppCompatActivity {

    private LinearLayout mLL;
    private int mLastY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_nested_scroll);

        mLL = findViewById(R.id.ll);

        mLL.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mLastY = (int) (event.getRawY() + 0.5f);

                    break;
                case MotionEvent.ACTION_MOVE:
                    int curY = (int) (event.getRawY() + 0.5f);
                    int disY = curY - mLastY;
                    mLL.scrollBy(mLL.getScrollX(), -disY);
                    mLastY = curY;

                    break;
            }

            return true;
        });
    }
}
