package com.szcx.market.utils;

import android.util.Log;

/**
 * Created by CharmingLee on 2015/5/20.
 */
public class MyLog {
    private static String TAG = "app";

    public static void i(Object message) {
        Log.i(TAG, "" + message);
    }

    public static void d(Object message) {
        Log.i(TAG, "" + message);
    }

    public static void e(String message) {
        Log.e(TAG, message);
    }
}
