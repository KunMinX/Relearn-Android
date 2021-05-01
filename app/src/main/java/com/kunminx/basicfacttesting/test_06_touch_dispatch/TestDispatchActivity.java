package com.kunminx.basicfacttesting.test_06_touch_dispatch;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.basicfacttesting.R;
import com.kunminx.utils.Logger;


/**
 * Create by KunMinX at 2018/10/18
 */
public class TestDispatchActivity extends AppCompatActivity {

    private static final String TAG = "info";
    private static final String NAME = TestDispatchActivity.class.getSimpleName();

    private Logger mLogger = new Logger(TAG, true);


    private TestInterceptViewGroup mVg;
    private TestInterceptViewGroup1 mVg1;
    private TestedView mTestedView;
    private TextView mTvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dispatch);

        mVg = (TestInterceptViewGroup) findViewById(R.id.touch_vg);
        mVg1 = (TestInterceptViewGroup1) findViewById(R.id.touch_vg_1);
        mTestedView = (TestedView) findViewById(R.id.test_view);
        mTvInfo = (TextView) findViewById(R.id.tv_info);

//        mVg.setEnabled(true);
//        mVg.setClickable(true);

        mVg.setOnTouchListener((v, event) -> {
            boolean result = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                mLogger.d(NAME + "-------ViewGroup onTouch is " + result
                        + " " + MotionEvent.actionToString(event.getAction()));
            }

            return result;
        });

        mVg.setOnClickListener(v -> mLogger.d(NAME + "-------ViewGroup onClick is going"));

        mVg1.setOnTouchListener((v, event) -> {
            boolean result = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                mLogger.d(NAME + "-------ViewGroup1 onTouch is " + result
                        + " " + MotionEvent.actionToString(event.getAction()));
            }
            return result;
        });

        mVg1.setOnClickListener(v -> mLogger.d(NAME + "-------ViewGroup1 onClick is going"));

        mTestedView.setOnTouchListener((v, event) -> {
            boolean result = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                mLogger.d(NAME + "-------TestView onTouch is " + result
                        + " " + MotionEvent.actionToString(event.getAction()));
            }

            return result;
        });

        mTestedView.setOnClickListener(v -> mLogger.d(NAME + "-------TestView onClick is going"));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        super.dispatchTouchEvent(ev);
//
//        boolean result = false;
        boolean result = super.dispatchTouchEvent(ev);

        mLogger.d(NAME + "-------Activity dispatchTouchEvent is " + result
                + " " + MotionEvent.actionToString(ev.getAction()));

        mTvInfo.setText("RawX: " + ev.getRawX() + "\nRawY: " + ev.getRawY());

        return result;
    }

}
