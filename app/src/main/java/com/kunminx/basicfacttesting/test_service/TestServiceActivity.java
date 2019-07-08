package com.kunminx.basicfacttesting.test_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.test01_lifecycle_test.BaseLifeCycleActivity;


/**
 * Create by KunMinX at 2018/10/12
 */
public class TestServiceActivity extends BaseLifeCycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);

    }

    private ServiceConnection mConnection1 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TestService.DownloadBinder binder = (TestService.DownloadBinder) service;
            binder.startDownload();
            binder.getProgress();
            binder.stopDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private ServiceConnection mConnection2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    public void startService(View view) {
        Intent intent = new Intent(TestServiceActivity.this, TestService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(TestServiceActivity.this, TestService.class);
        stopService(intent);
    }

    public void bindService(View view) {
        Intent intent = new Intent(TestServiceActivity.this, TestService.class);
        bindService(intent, mConnection1, BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        unbindService(mConnection1);
    }

    public void startIntentService(View view) {
        Intent intent = new Intent(TestServiceActivity.this, TestIntentService.class);
        startService(intent);
    }

    public void stopIntentService(View view) {
        Intent intent = new Intent(TestServiceActivity.this, TestIntentService.class);
        stopService(intent);
    }

    public void bindIntentService(View view) {
        Intent intent = new Intent(TestServiceActivity.this, TestIntentService.class);
        bindService(intent, mConnection2, BIND_AUTO_CREATE);
    }

    public void unbindIntentService(View view) {
        unbindService(mConnection2);
    }

    public void startForegroundService(View view) {
        /*Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);*/
    }

    public void stopForegroundService(View view) {
    }

    public void bindForegroundService(View view) {
    }

    public void unbindForegroundService(View view) {
    }
}
