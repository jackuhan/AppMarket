package com.szcx.market.network;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.android.volley.Response;
import com.google.gson.reflect.TypeToken;
import com.szcx.market.models.AppImage;
import com.szcx.market.models.AppInfoBean;
import com.szcx.market.models.AppListBean;
import com.szcx.market.models.BannerBean;
import com.szcx.market.models.NecessaryBean;
import com.szcx.market.models.TypeBean;
import com.szcx.market.models.UpdateBean;
import java.util.List;

/**
 * Created by C on 8/12/2015.
 */
public class ApiRequest {

    /**
     * 首页Banner
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<List<BannerBean>> getBannerList(
            @NonNull final Response.Listener<List<BannerBean>> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.BANNER_API,
                new TypeToken<List<BannerBean>>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * APP列表
     * @param p 0=最新  1=热门 2=推荐
     * @param typeId 分类ID
     * @param page 页码
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<AppListBean> getAppList(
            @IntRange int p,
            @IntRange int typeId,
            @IntRange int page,
            @NonNull final Response.Listener<AppListBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.getAppList(p, typeId, page),
                new TypeToken<AppListBean>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * 分类信息
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<List<TypeBean>> getTypeList(
            @NonNull final Response.Listener<List<TypeBean>> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.TYPE_API,
                new TypeToken<List<TypeBean>>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * app信息
     * @param appId
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<AppInfoBean> getAppInfo(
            @IntRange int appId,
            @NonNull final Response.Listener<AppInfoBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.getAppInfo(appId),
                new TypeToken<AppInfoBean>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * app信息，后台加统计
     * @param appId
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<AppInfoBean> getAppInfoWithBinding(
            @IntRange int appId,
            @NonNull final Response.Listener<AppInfoBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.getAppInfo(appId) + "&pst=1",
                new TypeToken<AppInfoBean>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * app截图
     * @param appId
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<List<AppImage>> getAppImages(
            @IntRange int appId,
            @NonNull final Response.Listener<List<AppImage>> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.getImages(appId),
                new TypeToken<List<AppImage>>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * 获取随机推荐的app ，放在详情页下面
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<AppListBean> getRecommendApps(
            @NonNull final Response.Listener<AppListBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.RECOMMEND_API,
                new TypeToken<AppListBean>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * 获取搜索App列表
     * @param key 关键词
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<AppListBean> getSearchApps(
            String key,
            @NonNull final Response.Listener<AppListBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.getSearch(key),
                new TypeToken<AppListBean>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * 获取更新信息
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<UpdateBean> getUpdateInfo(
            @NonNull final Response.Listener<UpdateBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.UPDATE_API,
                new TypeToken<UpdateBean>(){}.getType(),
                listener,
                errorListener
        );
    }

    /**
     * 获取必备Apps
     * @param listener
     * @param errorListener
     * @return
     */
    public static GsonGetRequest<NecessaryBean> getNecessaryApps(
            @NonNull final Response.Listener<NecessaryBean> listener,
            @NonNull final Response.ErrorListener errorListener
    ){
        return new GsonGetRequest<>(
                ApiHelper.NECESSARY_API,
                new TypeToken<NecessaryBean>(){}.getType(),
                listener,
                errorListener
        );
    }

}
