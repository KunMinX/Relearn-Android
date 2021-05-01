package com.kunminx.basicfacttesting.test_06_touch_dispatch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.kunminx.utils.Logger;

/**
 * Create by KunMinX at 2018/10/18
 */
public class TestedView extends View {

    private static final String TAG = "info";
    private static final String NAME = TestedView.class.getSimpleName();

    private Logger mLogger = new Logger(TAG, false);

    public TestedView(Context context) {
        super(context);
        mLogger.d(NAME + "----TestView(context)");
    }

    public TestedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mLogger.d(NAME + "----TestView(context,attrs)");
    }

    public TestedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLogger.d(NAME + "----TestView(context,attrs,defStyleAttr)");
    }

    /**
     * View在xml文件里加载完成时调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLogger.d(NAME + "----View onFinishInflate()");
    }

    /**
     * 测量View及其子View大小时调用
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mLogger.d(NAME + "----View onMeasure()");
    }

    /**
     * 布局View及其子View大小时调用
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mLogger.d(NAME + "----View onLayout() left = " + left + " top = " + top + " right = " + right + " bottom = " + bottom);
    }

    /**
     * View大小发生改变时调用
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mLogger.d(NAME + "----View onSizeChanged() w = " + w + " h = " + h + " oldw = " + oldw + " oldh = " + oldh);
    }

    /**
     * 绘制View及其子View大小时调用
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mLogger.d(NAME + "----View onDraw()");
    }

    /**
     * 物理按键事件发生时调用
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        mLogger.d(NAME + "----View onKeyDown() event = " + event.getAction());
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 物理按键事件发生时调用
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        mLogger.d(NAME + "----View onKeyUp() event = " + event.getAction());
        return super.onKeyUp(keyCode, event);
    }

    /**
     * 触摸事件发生时调用
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        super.onTouchEvent(event);

        boolean result = false;

        Log.d(TAG, NAME + "-------------------TestView onTouchEvent() is " + result
                + " " + MotionEvent.actionToString(event.getAction()));
//        mLogger.d(NAME + "----View onTouchEvent() event =  "
//                + " " + MotionEvent.actionToString(event.getAction()));

        return result;
    }

    /**
     * View获取焦点或者失去焦点时调用
     */
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        mLogger.d(NAME + "----View onFocusChanged() gainFocus = " + gainFocus);
    }

    /**
     * View所在窗口获取焦点或者失去焦点时调用
     */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        mLogger.d(NAME + "----View onWindowFocusChanged() hasWindowFocus = " + hasWindowFocus);
    }

    /**
     * View被关联到窗口时调用
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mLogger.d(NAME + "----View onAttachedToWindow()");
    }

    /**
     * View从窗口分离时调用
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mLogger.d(NAME + "----View onDetachedFromWindow()");
    }

    /**
     * View的可见性发生变化时调用
     */
    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        mLogger.d(NAME + "----View onVisibilityChanged() visibility = " + visibility);
    }

    /**
     * View所在窗口的可见性发生变化时调用
     */
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mLogger.d(NAME + "----View onWindowVisibilityChanged() visibility = " + visibility);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);

        boolean result = false;

        Log.d(TAG, NAME + "-------------------" + NAME + " dispatchTouchEvent is " + result
                + " " + MotionEvent.actionToString(ev.getAction()));

        return result;
    }
}
