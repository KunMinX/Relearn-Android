package com.kunminx.basicfacttesting.window_test;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class TestWindowActivity extends AppCompatActivity {

    private static final String TAG = "---TestWindowActivity";

    private FloatWindow mFloatWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_window);

    }


    public void showFloatWindow(View view) {
        if (mFloatWindow == null) {
            mFloatWindow = new FloatWindow(TestWindowActivity.this, WindowManager.LayoutParams.TYPE_APPLICATION_PANEL);
            mFloatWindow.setXY(0, 0);
            View toolView = mFloatWindow.inflateAndSetContentView(R.layout.layout_float_window);
        }
        if (!mFloatWindow.isShowing()) {
            mFloatWindow.show(getWindow().getDecorView());
        }
    }

    public void hideFloatWindow(View view) {
        if (mFloatWindow != null) {
            mFloatWindow.dismiss();
        }
    }


}
