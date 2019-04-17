package com.wzx.test;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created By WuZhouXing TestApplication
 * 2019/4/17 16:29
 */
public class LocalService extends Service {
    Sub_service myService;
    MyServiceConnection myServiceConnection;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1 = new Intent();
        intent1.setClass(this, RemoteService.class);
        bindService(intent1, myServiceConnection, Context.BIND_IMPORTANT);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    class Sub_service extends ISubService.Stub {


        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getServiceName() throws RemoteException {
            return null;
        }
    }

    public void init() {
        if (myService == null) {
            myServiceConnection = new MyServiceConnection();
        }
        myService = new Sub_service();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return myService;
    }


    class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocalService.this.startService(new Intent(LocalService.this, RemoteService.class));
            LocalService.this.bindService(new Intent(LocalService.this, RemoteService.class), myServiceConnection, Context.BIND_IMPORTANT);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    ;
}
