package com.szcx.market.network;

/**
 * Created by C on 8/12/2015.
 */
public class ApiHelper {


    public static final String HOST = "http://m1.15ve.com/";

    /** 最新 **/
    public static final int P_NEWS = 0;
    /** 热门 **/
    public static final int P_HOTS = 1;
    /** 推荐/精品 **/
    public static final int P_RECOMMEND = 2;
    /**软件*/
    public static final int TYPE_APP = -1;
    /**游戏*/
    public static final int TYPE_GAME = -2;
    /**首页*/
    public static final int TYPE_HOME =0;

    /**系统工具**/
    public static final int TYPE_SYSTEM_TOOLS = 1;
    /**生活娱乐**/
    public static final int TYPE_ENTERTAINMENT = 2;
    /**影音视听**/
    public static final int TYPE_AUDIO_VIDEO = 3;
    /**通讯社交**/
    public static final int TYPE_IM = 4;
    /**新闻阅读**/
    public static final int TYPE_NEWS = 5;
    /**办公商务**/
    public static final int TYPE_OFFICE = 6;

    /**角色扮演**/
    public static final int TYPE_RPG = 11;
    /**休闲益智**/
    public static final int TYPE_CASUAL = 12;
    /**动作冒险**/
    public static final int TYPE_ACT = 13;
    /**体育竞速**/
    public static final int TYPE_SPORTS = 14;
    /**飞行射击**/
    public static final int TYPE_FLIGHT_SHOOTING = 15;
    /**其它相关**/
    public static final int TYPE_OTHER = 16;

    /**
     * 首页头部banner信息
     */
    public static final String BANNER_API = HOST + "getrec.ashx";

    /**
     * 分类信息
     */
    public static final String TYPE_API = HOST + "gettype.ashx";

    public static final int  Time=500;
    /**
     * 返回列表数据
     * @param p 0=最新  1=热门 2=推荐
     * @param typeId 分类ID
     * @param page 页码
     * @return api
     */
    public static String getAppList(int p, int typeId, int page){
        return HOST + "getlist.ashx?p=" + p + "&typeid=" + typeId + "&page=" + page;
    }

    /**
     * 返回应用信息
     * @param appId 应用ID
     * @return api
     */
    public static String getAppInfo(int appId){
        return HOST + "getappinfo.ashx?appid=" + appId;
    }

    /**
     * 应用截图信息
     * @param appId 应用ID
     * @return api
     */
    public static String getImages(int appId){
        return HOST + "getimages.ashx?appid=" + appId;
    }

    /**
     * APP下载地址
     * @param appId 应用ID
     * @return api
     */
    public static String getDownUrl(int appId){
        // TODO: 16/8/25 写死apk地址
        return "http://hot.m.shouji.360tpcdn.com/160815/663bf20ac1cdfb3d91247d22292806f3/com.qihoo.appstore_300050185.apk";
        //return HOST + "down.ashx?id=" + appId;
    }

    /** 返回随机推荐的app **/
    public static String RECOMMEND_API = HOST + "gerecapp.ashx";

    /**
     * 搜索
      * @param key 关键词
     * @return api
     */
    public static String getSearch(String key){
        return HOST + "s.ashx?key=" + key;
    }

    /** 必备 **/
    public static String NECESSARY_API = HOST + "gzt.ashx?id=1";

    /** 更新 **/
    public static String UPDATE_API = HOST + "update.ashx";
}
