package com.kunminx.basicfacttesting.test_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * Create by KunMinX at 19/7/8
 */
public class TestService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    static class DownloadBinder extends Binder {
        public int getProgress() {
            return 0;
        }

        public void startDownload() {

        }

        public void stopDownload() {

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
