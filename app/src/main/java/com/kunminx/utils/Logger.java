package com.kunminx.utils;
/*
 * Copyright (c) 2018-2019. KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.util.Log;

/**
 * Create by KunMinX at 19/6/16
 */
public class Logger {

    private String TAG = "";
    private boolean enableLog;

    public Logger() {
    }

    public Logger(String TAG) {
        this.TAG = TAG;
    }

    public Logger(String TAG, boolean enableLog) {
        this.TAG = TAG;
        this.enableLog = enableLog;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public boolean isEnableLog() {
        return enableLog;
    }

    public void setEnableLog(boolean enableLog) {
        this.enableLog = enableLog;
    }

    public void d(String log) {
        if (enableLog) {
            Log.d(TAG, log);
        }
    }

    public void e(String log) {
        if (enableLog) {
            Log.e(TAG, log);
        }
    }

    public void i(String log) {
        if (enableLog) {
            Log.i(TAG, log);
        }
    }

    public void w(String log) {
        if (enableLog) {
            Log.w(TAG, log);
        }
    }

    public void v(String log) {
        if (enableLog) {
            Log.v(TAG, log);
        }
    }
}
