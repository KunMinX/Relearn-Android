package com.kunminx.basicfacttesting.touch_dispatch_test;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

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
    private TestView mTestView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dispatch);

        mVg = (TestInterceptViewGroup) findViewById(R.id.touch_vg);
        mVg1 = (TestInterceptViewGroup1) findViewById(R.id.touch_vg_1);
        mTestView = (TestView) findViewById(R.id.test_view);

//        mVg.setEnabled(true);
//        mVg.setClickable(true);

        mVg.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean result = false;
                mLogger.d(NAME + "-------TestInterceptViewGroup onTouch is " + result
                        + " " + MotionEvent.actionToString(event.getAction()));

                return result;
            }
        });

        mVg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogger.d(NAME + "-------TestInterceptViewGroup onClick is going");

            }
        });

        mVg1.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean result = false;
                mLogger.d(NAME + "-------TestInterceptViewGroup1 onTouch is " + result
                        + " " + MotionEvent.actionToString(event.getAction()));
                return result;
            }
        });

        mVg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogger.d(NAME + "-------TestInterceptViewGroup1 onClick is going");

            }
        });

        mTestView.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean result = false;
                mLogger.d(NAME + "-------TestView onTouch is " + result
                        + " " + MotionEvent.actionToString(event.getAction()));

                return result;
            }
        });

        mTestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLogger.d(NAME + "-------TestView onClick is going");

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);

        boolean result = false;

        mLogger.d(NAME + "-------Activity dispatchTouchEvent is " + result
                + " " + MotionEvent.actionToString(ev.getAction()));

        return result;
    }
}
