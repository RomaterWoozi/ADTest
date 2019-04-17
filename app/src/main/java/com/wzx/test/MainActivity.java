package com.wzx.test;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wzx.test.subprocess.PrivateProcessActivity;

import static com.wzx.test.Util.setCurrentRunningProcess;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView mGLView;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        mGLView = new GLSurfaceView(this);
        setContentView(R.layout.activity_main);
//
//        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        setCurrentRunningProcess(tv, this);

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
        if (supportEs2) {
            mGLView.setEGLContextClientVersion(2);
            mGLView.setRenderer(new LessonOneRenderer());
        } else {
            return;
        }

//        setContentView(mGLView);
    }


    public void onStartActivityBtnClick(View view) {
        Intent intent = new Intent(this, PrivateProcessActivity.class);
        startActivity(intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    @Override
    protected void onResume() {
        super.onResume();
        mGLView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLView.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            } else {

            }
        }
    }
}
