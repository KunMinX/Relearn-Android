package com.kunminx.basicfacttesting.test_08_window;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class TestWindowActivity extends AppCompatActivity {

    private static final String TAG = "---TestWindowActivity";

    private MoveView mTvMove;
    private TextView mTvLong;
    private View mView;

    private int mLastX;
    private int mLastY;
    WindowManager.LayoutParams wml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_window);

        mTvMove = findViewById(R.id.tv_move);
        mTvLong = findViewById(R.id.tv_1);
    }


    public void showFloatWindow(View view) {

        mView = View.inflate(getApplicationContext(), R.layout.layout_float_window, null);
        mView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mLastX = (int) (event.getRawX() + 0.5f);
                    mLastY = (int) (event.getRawY() + 0.5f);

                    break;
                case MotionEvent.ACTION_MOVE:
                    int curX = (int) (event.getRawX() + 0.5f);
                    int curY = (int) (event.getRawY() + 0.5f);
                    int disX = curX - mLastX;
                    int disY = curY - mLastY;

                    wml.x = wml.x + disX;
                    wml.y = wml.y + disY;
                    getWindowManager().updateViewLayout(mView, wml);

                    mLastX = curX;
                    mLastY = curY;

                    break;
            }

            return true;
        });

        wml = new WindowManager.LayoutParams();
        wml.gravity = Gravity.START | Gravity.TOP;
        wml.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wml.height = WindowManager.LayoutParams.WRAP_CONTENT;
        wml.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        wml.x = 0;
        wml.y = 0;
        getWindowManager().addView(mView, wml);
    }

    public void hideFloatWindow(View view) {
        if (mView != null) {
            getWindowManager().removeView(mView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("TAG", "mLeft:" + mTvLong.getLeft() + " mRight:" + mTvLong.getRight()
                + " mTop:" + mTvLong.getTop() + " mBottom:" + mTvLong.getBottom()
                + " width:" + mTvLong.getWidth() + " height:" + mTvLong.getHeight()
                + " measureWidth:" + mTvLong.getMeasuredWidth() + " measureHeight:" + mTvLong.getMeasuredHeight());

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Log.d("TAG", "mLeft:" + mTvLong.getLeft() + " mRight:" + mTvLong.getRight()
                + " mTop:" + mTvLong.getTop() + " mBottom:" + mTvLong.getBottom()
                + " width:" + mTvLong.getWidth() + " height:" + mTvLong.getHeight()
                + " measureWidth:" + mTvLong.getMeasuredWidth() + " measureHeight:" + mTvLong.getMeasuredHeight());

    }
}
