package com.kunminx.basicfacttesting.window_test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.databinding.ActivityTestWindowBinding;


/**
 * Create by KunMinX at 2018/10/18
 */
public class TestWindowActivity extends AppCompatActivity {

    private static final String TAG = "---TestWindowActivity";

    private ActivityTestWindowBinding mBinding;
    private FloatWindow mFloatWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_window);
        mBinding.setClick(new ClickProxy());
    }

    public class ClickProxy {

        public void showFloatWindow() {
            if (mFloatWindow == null) {
                mFloatWindow = new FloatWindow(TestWindowActivity.this, WindowManager.LayoutParams.TYPE_APPLICATION_PANEL);
                mFloatWindow.setXY(0, 0);
                View toolView = mFloatWindow.inflateAndSetContentView(R.layout.layout_float_window);
            }
            if (!mFloatWindow.isShowing()) {
                mFloatWindow.show(getWindow().getDecorView());
            }
        }

        public void hideFloatWindow() {
            if (mFloatWindow != null) {
                mFloatWindow.dismiss();
            }
        }
    }

}
