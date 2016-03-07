LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := ndkfoo
LOCAL_SRC_FILES := ndkfoo.c
LOCAL_CFLAGS += -D__STDC_CONSTANT_MACROS
LOCAL_LDLIBS := -llog  -lz
LOCAL_SHARED_LIBRARIES := libavformat libavcodec libswscale libavutil libswresample

include $(BUILD_SHARED_LIBRARY)
$(call import-module,FFmpeg/android/arm)