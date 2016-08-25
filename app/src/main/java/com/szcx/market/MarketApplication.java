package com.szcx.market;

import android.app.Application;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.szcx.market.download.DownloadManager;
import com.szcx.market.download.DownloadService;
import com.szcx.market.network.OkHttpStack;
import com.szcx.market.utils.Utils;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by C on 8/12/2015.
 */
public class MarketApplication extends Application {

    private static MarketApplication mInstance;

    private RequestQueue mRequestQueue;
    private Gson mGson;

    private ExecutorService mCachedThreadPool;
    public static DownloadManager downloadManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        initDownloader();

        downloadManager = DownloadService.getDownloadManager(MarketApplication.this);
    }

    public static DownloadManager getDownloadManager() {
        return downloadManager;
    }

    private void initDownloader() {
        File downloadDir = Utils.getDownloadDir();
        if (!downloadDir.exists() || !downloadDir.isDirectory()) {
            downloadDir.mkdirs();
        }

    }

    public static MarketApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getVolleyRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this, new OkHttpStack(new OkHttpClient()));
        }
        return mRequestQueue;
    }

    private static void addRequest(@NonNull final Request<?> request) {
        getInstance().getVolleyRequestQueue().add(request);
    }

    public static void addRequest(@NonNull final Request<?> request, @NonNull final String tag) {
        request.setTag(tag);
        addRequest(request);
    }

    public Gson getGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
        return mGson;
    }

    public ExecutorService getCachedThreadPool() {
        if (mCachedThreadPool == null) {
            mCachedThreadPool = Executors.newCachedThreadPool();
        }
        return mCachedThreadPool;
    }

}
