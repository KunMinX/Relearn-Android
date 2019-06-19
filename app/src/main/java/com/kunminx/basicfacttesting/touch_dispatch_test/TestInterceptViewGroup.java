package com.kunminx.basicfacttesting.touch_dispatch_test;
/*
 * Copyright (c) 2018-2019. KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.RequiresApi;

import com.kunminx.utils.Logger;

/**
 * Create by KunMinX at 19/6/16
 */
public class TestInterceptViewGroup extends FrameLayout {

    private static final String TAG = "info";
    protected String NAME = TestInterceptViewGroup.class.getSimpleName();

    protected Logger mLogger = new Logger(TAG, true);

    public TestInterceptViewGroup(Context context) {
        super(context);
    }

    public TestInterceptViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestInterceptViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);

        boolean result = false;

        mLogger.d(NAME + "-----" + "ViewGroup onInterceptTouchEvent is "
                + result + " " + MotionEvent.actionToString(ev.getAction()));

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        super.onTouchEvent(event);
//
//        boolean result = false;
        boolean result = super.onTouchEvent(event);

        mLogger.d(NAME + "-----" + "ViewGroup onTouchEvent is "
                + result + " " + MotionEvent.actionToString(event.getAction()));

        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        super.dispatchTouchEvent(ev);
//
//        boolean result = false;
        boolean result = super.dispatchTouchEvent(ev);

        mLogger.d(NAME + "-----" + "ViewGroup dispatchTouchEvent is " + result
                + " " + MotionEvent.actionToString(ev.getAction()));

        return result;
    }
}
