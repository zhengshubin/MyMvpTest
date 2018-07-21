package com.gdqt.mymvptest.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import com.gdqt.mymvptest.Application.MyApplication;
import com.gdqt.mymvptest.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public  class DisklrucacheUtils {
    /**
     * 获取缓存地址
     */
    public static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    /**
     * 获取到当前应用程序的版本号
     *
     * @param context
     * @return
     */
    public  static  int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 创建 DiskLruCache 对象
     */
    public  static DiskLruCache getDiskLruCache() throws IOException {
        File cacheDir = getDiskCacheDir(MyApplication.getContext(), "object");//缓存路径
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        //获取 DiskLruCache 实例,此处第二个参数为应用版本号,第三个参数为缓存的节点数量
        return DiskLruCache.open(cacheDir, getAppVersion(MyApplication.getContext()), 1, 1024 * 1024 * 10);
    }


    /**
     * 读取缓存中的数据
     */
    public  static List<Map<String, Object>> getLocalData() {
        String key = "userdata";
        try {
            DiskLruCache.Snapshot snapShot = getDiskLruCache().get(key);
            if (snapShot != null) {
                InputStream inputStream = snapShot.getInputStream(0);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Object on = objectInputStream.readObject();
                List<Map<String, Object>> list = new ArrayList<>();
                list.addAll((List<LinkedHashMap<String, Object>>) on);
                return list;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加入缓存中的数据
     */
    public static boolean setLocalData(List list) throws IOException {
        DiskLruCache mDiskLruCache = getDiskLruCache();
        String key = "userdata";
        DiskLruCache.Editor editor = mDiskLruCache.edit(key);
        try {
            OutputStream outputStream = editor.newOutputStream(0);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            output.writeObject(list);
            if (editor != null) {
                editor.commit();
            }
            mDiskLruCache.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        editor.abort();
        return false;
    }
}
