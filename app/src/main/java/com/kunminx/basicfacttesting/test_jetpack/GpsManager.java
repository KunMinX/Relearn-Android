package com.kunminx.basicfacttesting.test_jetpack;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Create by KunMinX at 19/7/7
 */
public class GpsManager {

    private static GpsManager sGpsManager=new GpsManager();

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
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                for (; ; ) {
                    if (!mIsActive) {
                        return;
                    }
                }
            }
        }).subscribe();
    }
}
