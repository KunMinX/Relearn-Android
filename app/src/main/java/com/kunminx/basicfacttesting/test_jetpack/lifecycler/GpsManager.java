package com.kunminx.basicfacttesting.test_jetpack.lifecycler;

import io.reactivex.Observable;

/**
 * Create by KunMinX at 19/7/7
 */
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
