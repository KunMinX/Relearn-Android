package com.kunminx.basicfacttesting.test_service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

/**
 * Create by KunMinX at 19/7/8
 */
public class TestIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        
    }
}
