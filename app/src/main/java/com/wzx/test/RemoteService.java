package com.wzx.test;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

/**
 * Created By WuZhouXing TestApplication
 * 2019/4/17 16:58
 */
public class RemoteService extends Service {
    private MyConnection myConnection;
    private MyBinder binder;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1=new Intent(RemoteService.this,LocalService.class);
        bindService(intent1,myConnection,Context.BIND_IMPORTANT);
        return START_STICKY;
    }

    public void init(){
        binder=new MyBinder();
        if(myConnection==null){
            myConnection=new MyConnection();
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("获取远程连接");
        }

        @Override
        public void onServiceDisconnected(ComponentName nme) {
            Toast.makeText(RemoteService.this, "本地连接被干掉了", Toast.LENGTH_SHORT).show();
            RemoteService.this.startService(new Intent(RemoteService.this,
                    LocalService.class));
            RemoteService.this.bindService(new Intent(RemoteService.this,
                    LocalService.class), myConnection, Context.BIND_IMPORTANT);
        }
    }


     class MyBinder extends ISubService.Stub{
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getServiceName() throws RemoteException {
            return null;
        }
    }
}
