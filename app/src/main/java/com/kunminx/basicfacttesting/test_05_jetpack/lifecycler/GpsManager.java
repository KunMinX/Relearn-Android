package com.kunminx.basicfacttesting.test_05_jetpack.lifecycler;

import io.reactivex.Observable;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * Create by KunMinX at 19/7/7
 */
@Deprecated
public class GpsManager {

    private static GpsManager sGpsManager = new GpsManager();

    public static GpsManager getInstance() {
        return sGpsManager;
    }

    private GpsManager() {
    }

    private boolean mIsActive;

    public boolean isActive() {
        return mIsActive;
    }

    public void setActive(boolean active) {
        mIsActive = active;
    }

    public void onResume() {
        calculate();
    }

    public void onPause() {
        // ...
    }

    public void onDestroy() {
        // ...
    }

    public void calculate() {
        Observable.create(emitter -> {
            for (; ; ) {
                if (!mIsActive) return;
            }
        }).subscribe();
    }
}
