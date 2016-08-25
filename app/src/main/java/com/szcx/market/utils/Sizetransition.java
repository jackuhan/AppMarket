package com.szcx.market.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2015/12/21.
 */
public class Sizetransition {
    /**
     * 取得文件大小
     *
     * @param f
     * @return
     * @throws Exception
     */
    public static long getFileSizes(File f) throws Exception {
        long s = 0;
        if (f.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
            s = fis.available();
        } else {
            f.createNewFile();
        }
        return s;
    }

    /**
     * 转换文件大小
     *
     * @param fileS
     * @return
     */
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    public static String FormetunitSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.0");
        String fileSizeString = "";
        if (fileS < 10000) {
            fileSizeString = df.format((double) fileS) + "次";
        } else if (fileS < 100000) {
            fileSizeString = df.format((double) fileS / 10000) + "万次";
        } else if (fileS > 1000000) {
            fileSizeString = df.format((double) fileS / 10000) + "万次";
        } else if (fileS > 10000000) {
            fileSizeString = df.format((double) fileS / 1000000) + "千万次";
        } else if (fileS > 100000000) {
            fileSizeString = df.format((double) fileS / 10000000) + "亿次";
        }
        return fileSizeString;
    }

    public static String cut(String strs) {
        String str = "";
        if (strs != null)
            str=strs.substring(0,10);
        return str;
    }
}
