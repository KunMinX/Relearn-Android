package com.kunminx.basicfacttesting.window_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

/**
 * @author xmj
 * @date 2020/3/9
 */
public class MoveView extends androidx.appcompat.widget.AppCompatTextView {

    private int mLastX;
    private int mLastY;


    public MoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
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
                setX(getX() + disX);
                setY(getY() + disY);
                invalidate();

                mLastX = curX;
                mLastY = curY;

                break;
        }


        return true;
    }
}
