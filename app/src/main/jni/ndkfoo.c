#include <jni.h>
#include <android/log.h>

int main(const char *infileName, const char *outFileName) {
    //  Stuffs here
}

JNIEXPORT jstring JNICALL Java_com_cprakashagr_videoeditor_MainActivity_getFromNative(JNIEnv* env, jobject javaThis, jstring in_fileName, jstring out_fileName) {

    doMain((*env)->GetStringUTFChars(env, in_fileName, NULL), (*env)->GetStringUTFChars(env, out_fileName, NULL));
    return (*env)->NewStringUTF(env, "Hello from native code!");
}
