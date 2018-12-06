package cn.easier.baselibs.utils;

import android.util.Log;

/**
 * File: DHLog.java
 * 作者: 大海
 * 创建日期: 2018/7/18 0018 12:18
 * 描述：
 */
public class DHLog {

    private static boolean isShowLog = true;
    public static void e(String TAG,String msg){
        if (isShowLog)
        Log.e(TAG, "msg: " + msg );
    }

    public static void e(String TAG,String msg,Throwable throwable){
        if (isShowLog)
        Log.e(TAG, "msg: " + msg ,throwable );
    }

    public static void d(String TAG,String msg){
        if (isShowLog)
            Log.e(TAG, "msg: " + msg );
    }
}
