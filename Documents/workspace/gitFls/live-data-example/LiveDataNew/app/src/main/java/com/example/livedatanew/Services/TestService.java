package com.example.livedatanew.Services;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class TestService extends Service {

    final class TestThread implements Runnable
    {
        int startId;

        public TestThread(int startId) {
            this.startId = startId;
        }

        @Override
        public void run() {
            int i = 0;
            synchronized (this)
            {
                while (i<10) {
                    try {
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        Log.d("INTERUPTED", "run: " + e);
                    }
                }
                stopSelf(startId);
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new TestThread(startId));
        thread.start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
