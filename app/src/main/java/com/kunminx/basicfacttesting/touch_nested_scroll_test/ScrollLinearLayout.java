package com.kunminx.basicfacttesting.touch_nested_scroll_test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author KunMinX
 * @date 2020/3/12
 */
public class ScrollLinearLayout extends LinearLayout {

    private int mOriX;
    private int mOriY;
    private int mLastScrollY;


    public ScrollLinearLayout(Context context) {
        super(context);
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int x = (int) (event.getRawX() + 0.5f);
        int y = (int) (event.getRawY() + 0.5f);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mOriX = x;
                mOriY = y;
                Log.d("TAG_SLL_OI_DOWN", "mDownX:" + mOriX + " mDownY:" + mOriY);
                return false;
            case MotionEvent.ACTION_UP:
                return false;
            case MotionEvent.ACTION_MOVE:
                int dx = x - mOriX;
                int dy = y - mOriY;
                int orientation = getOrientation(dx, dy);
                Log.d("TAG_SLL_OI_MOVE", "x:" + x + " y:" + y + " ori:" + orientation);
                boolean consumed = false;
                switch (orientation) {
                    case 'r':
                    case 'l':
                        consumed = false;
                    case 't':
                    case 'b':
                        consumed = true;
                }
                return consumed;
        }

        return super.onInterceptTouchEvent(event);
    }

    private int getOrientation(int dx, int dy) {
        if (Math.abs(dx) > Math.abs(dy)) {
            return dx > 0 ? 'r' : 'l';
        } else {
            return dy > 0 ? 'b' : 't';
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastScrollY = (int) (event.getRawY() + 0.5f);
//                Log.d("TAG_SLL_OTE_DOWN", "mLastY:" + mLastScrollY);
                return true;
            case MotionEvent.ACTION_MOVE:
                int curY = (int) (event.getRawY() + 0.5f);
                int disY = curY - mLastScrollY;
//                Log.d("TAG_SLL_OTE_MOVE", " curY:" + curY + " disY:" + disY);
                scrollBy(getScrollX(), -disY);
                mLastScrollY = curY;
                return true;
        }
        return super.onTouchEvent(event);
    }
}
