package com.wzx.test;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created By WuZhouXing TestApplication
 * 2019/4/10 10:24
 */
public class LessonOneRenderer implements GLSurfaceView.Renderer {



    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f,0.0f,0.0f,1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
         GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
