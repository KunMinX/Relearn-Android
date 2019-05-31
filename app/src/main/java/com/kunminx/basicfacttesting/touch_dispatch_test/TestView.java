package com.kunminx.basicfacttesting.touch_dispatch_test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Create by KunMinX at 2018/10/18
 */
public class TestView extends View {

    private static final String TAG = "info";
    private static final String NAME = TestView.class.getSimpleName();


    public TestView(Context context) {
        super(context);
        Log.d(TAG, NAME + "----TestView(context)");
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, NAME + "----TestView(context,attrs)");
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, NAME + "----TestView(context,attrs,defStyleAttr)");
    }

    /**
     * View在xml文件里加载完成时调用
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, NAME + "----View onFinishInflate()");
    }

    /**
     * 测量View及其子View大小时调用
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, NAME + "----View onMeasure()");
    }

    /**
     * 布局View及其子View大小时调用
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, NAME + "----View onLayout() left = " + left + " top = " + top + " right = " + right + " bottom = " + bottom);
    }

    /**
     * View大小发生改变时调用
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, NAME + "----View onSizeChanged() w = " + w + " h = " + h + " oldw = " + oldw + " oldh = " + oldh);
    }

    /**
     * 绘制View及其子View大小时调用
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, NAME + "----View onDraw()");
    }

    /**
     * 物理按键事件发生时调用
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, NAME + "----View onKeyDown() event = " + event.getAction());
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 物理按键事件发生时调用
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(TAG, NAME + "----View onKeyUp() event = " + event.getAction());
        return super.onKeyUp(keyCode, event);
    }

    /**
     * 触摸事件发生时调用
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, NAME + "----View onTouchEvent() event =  " + event.getAction());
        return super.onTouchEvent(event);
    }

    /**
     * View获取焦点或者失去焦点时调用
     */
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.d(TAG, NAME + "----View onFocusChanged() gainFocus = " + gainFocus);
    }

    /**
     * View所在窗口获取焦点或者失去焦点时调用
     */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.d(TAG, NAME + "----View onWindowFocusChanged() hasWindowFocus = " + hasWindowFocus);
    }

    /**
     * View被关联到窗口时调用
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, NAME + "----View onAttachedToWindow()");
    }

    /**
     * View从窗口分离时调用
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, NAME + "----View onDetachedFromWindow()");
    }

    /**
     * View的可见性发生变化时调用
     */
    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.d(TAG, NAME + "----View onVisibilityChanged() visibility = " + visibility);
    }

    /**
     * View所在窗口的可见性发生变化时调用
     */
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Log.d(TAG, NAME + "----View onWindowVisibilityChanged() visibility = " + visibility);
    }

}
