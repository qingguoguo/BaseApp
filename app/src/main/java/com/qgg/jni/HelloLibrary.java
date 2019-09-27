package com.qgg.jni;

/**
 * @author :qingguoguo
 * @datetime ：2019/9/27
 * @describe :
 */
public class HelloLibrary {
    static {
        //ndk-build，这里对应 Android.mk 里的 LOCAL_MODULE := NDKSample
        //CMake，这里对应 CMakeLists.txt 里的 add_library NDKSample
        System.loadLibrary("NDKSample");
    }
    public native String sayHello();
}
