#include <jni.h>
extern "C"
JNIEXPORT jstring JNICALL Java_com_qgg_jni_HelloLibrary_sayHello(JNIEnv *env, jobject instance) {
    //从 C++ 传字符串到 Java
    return env->NewStringUTF("Hello from C++");
}