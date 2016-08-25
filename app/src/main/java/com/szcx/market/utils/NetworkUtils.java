package com.szcx.market.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by C on 15/1/2016.
 * Nukc
 */
public class NetworkUtils {

    /**
     * 检查是否有wifi
     * @param context
     * @return
     */
    public static boolean isWifi(Context context){
        ConnectivityManager mConnectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //检查网络连接，如果无网络可用，就不需要进行连网操作等
        NetworkInfo info = mConnectivity.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        //判断网络连接类型，只有在3G或wifi里进行一些数据更新。
        int netType = info.getType();
        if (netType == ConnectivityManager.TYPE_WIFI) {
            return info.isConnected();
        } else {
            return false;
        }

//		NetworkInfo mWifi = mConnectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//		return mWifi.isConnected();
    }
}
