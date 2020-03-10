package com.kunminx.basicfacttesting.touch_nested_scroll_test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.kunminx.utils.SizeUtils;

/**
 * @author xmj
 * @date 2020/3/10
 */
public class CoordinateView extends View {

    private Paint mPaint = new Paint();
    private Paint mPaint1 = new Paint();
    private RectF mRectF = new RectF();
    private int mTextSize = SizeUtils.sp2px(16);
    private int mRadius = SizeUtils.sp2px(12);

    public CoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED);
        mPaint.setTextSize(mTextSize);
        canvas.drawText(getLeft() + " , " + getTop(), 50, 100, mPaint);
        canvas.drawText(getRight() + " , " + getTop(), getWidth() - 400, 100, mPaint);
        canvas.drawText(getLeft() + " , " + getBottom(), 50, getHeight() - 100, mPaint);
        canvas.drawText(getRight() + " , " + getBottom(), getWidth() - 400, getHeight() - 100, mPaint);

        mPaint1.setColor(Color.GRAY);
        mPaint1.setStyle(Paint.Style.STROKE);
        mRectF.set(10, 10, getWidth() - 10, getHeight() - 10);
        canvas.drawRoundRect(mRectF, mRadius, mRadius, mPaint1);

        Log.d("TAG", getLeft() + " " + getRight() + " " + getTop() + " " + getBottom());
    }
}
