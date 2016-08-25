package com.szcx.market.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by C on 29/12/2015.
 * Nukc
 */
public class FileUtils {

    /**
     * 根据后辍查找文件
     * @param dir
     * @param suffix
     */
    public static ArrayList<String> findSuffixFiles(String dir, String suffix){
        ArrayList<String> _files = new ArrayList<>();

        LinkedList<File> fileList = new LinkedList<>();
        File dirFile = new File(dir);
        File files[] = dirFile.listFiles();

        if (files == null) return _files;

        for (File f : files){
            if (f.isDirectory()){
                fileList.add(f);
            }else {
                if (f.getName().endsWith(suffix))
                    _files.add(f.getPath());
            }
        }

        File tmp;
        while (!fileList.isEmpty()){
            tmp = fileList.removeFirst();
            if (tmp == null) continue;

            if (tmp.isDirectory()){
                fileList.add(tmp);
            }else {
                if (tmp.getName().endsWith(suffix))
                   _files.add(tmp.getPath());
            }
        }

        return _files;
    }


    public static boolean deleteFile(String path) {
        if (path == null || path.trim().length() == 0) {
            return true;
        }

        File file = new File(path);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return false;
        }
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                f.delete();
            } else if (f.isDirectory()) {
                deleteFile(f.getAbsolutePath());
            }
        }
        return file.delete();
    }

}
