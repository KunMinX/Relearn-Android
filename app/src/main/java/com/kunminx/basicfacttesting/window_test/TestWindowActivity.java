package com.kunminx.basicfacttesting.window_test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.databinding.ActivityTestWindowBinding;


/**
 * @author KunMinX
 * @date 2018/10/18
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
            /*if (mFloatWindow == null) {
                mFloatWindow = new FloatWindow(TestWindowActivity.this, WindowManager.LayoutParams.TYPE_APPLICATION_PANEL);
                mFloatWindow.setXY((int) getResources().getDimension(
                        R.dimen.title_height) * 2, mIsPad ?
                        DisplayUtils.getScreenHeight(mActivity) - (int) getResources().getDimension(R.dimen.title_height)
                        : (int) getResources().getDimension(R.dimen.title_height) * 3);
                View toolView = mFloatWindow.inflateAndSetContentView(R.layout.float_window_gps_info_simple);
            }
            if (!mFloatWindow.isShowing()) {
                mFloatWindow.show(getWindow().getDecorView());
            }*/
        }
    }

}
