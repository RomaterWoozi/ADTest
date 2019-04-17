#include <jni.h>
#include <string>
#include <pthread.h>
#include <android/storage_manager.h>
#include <android/obb.h>
#include <android/native_window.h>
#include "debug.h"
//#include <storage_manager.h>
extern "C" JNIEXPORT jstring JNICALL
Java_com_wzx_test_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    LOGD("input params %s %d","is a test",3);

    return env->NewStringUTF(hello.c_str());
}
