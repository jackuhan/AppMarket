package com.szcx.market.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import com.szcx.market.R;
import com.szcx.market.models.AppDownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by C on 9/12/2015.
 */
public class Utils {

    private static int screenWidth = 0;
    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point size = new Point();
                display.getSize(size);
                screenWidth = size.x;
            }else {
                screenWidth = display.getWidth();
            }
        }

        return screenWidth;
    }

    private static final DecimalFormat DF = new DecimalFormat("0.00");
    public static String getDownloadPerSize(long finished, long total) {
        return DF.format((float) finished / (1024 * 1024)) + "M/" + DF.format((float) total / (1024 * 1024)) + "M";
    }

    private static File mDownloadDir;
    public static File getDownloadDir(){
        if (mDownloadDir == null) {
            mDownloadDir = new File(Environment.getExternalStorageDirectory(), "Market");
        }
        return mDownloadDir;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(0);
        if (!ListUtils.isEmpty(packages)) {
            for (PackageInfo packageInfo : packages) {
                if (packageInfo.packageName.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static String getApkFileName(AppDownloadInfo info){
        return getApkFileName(info.getPackageName(), info.getVersion());
    }

    public static String getApkFileName(String packageName, String version){
        return packageName + "-" + version + ".apk";
    }

    public static String getButtonText(Context context, int status){
        switch (status) {
            case AppDownloadInfo.STATUS_NOT_DOWNLOAD:
                return context.getString(R.string.download);
            case AppDownloadInfo.STATUS_CONNECTING:
                return context.getString(R.string.cancel);
            case AppDownloadInfo.STATUS_CONNECT_ERROR:
                return context.getString(R.string.try_again);
            case AppDownloadInfo.STATUS_DOWNLOADING:
                return context.getString(R.string.pause);
            case AppDownloadInfo.STATUS_PAUSED:
                return context.getString(R.string.resume);
            case AppDownloadInfo.STATUS_DOWNLOAD_ERROR:
                return context.getString(R.string.try_again);
            case AppDownloadInfo.STATUS_COMPLETE:
                return context.getString(R.string.install);
            case AppDownloadInfo.STATUS_INSTALLED:
                return context.getString(R.string.uninstall);
            default:
                return context.getString(R.string.download);
        }
    }
}
