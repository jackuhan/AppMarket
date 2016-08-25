package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by C on 8/12/2015.
 */
public class BannerBean implements Parcelable {

    /**
     * id : 8
     * appid : 2
     * imgurl : http://www.duba.com/static/images/public/20131224/0dc6b17e1c026ac09246ec52c3778a2c.png
     */

    private int id;
    private int appid;
    private String imgurl;

    public void setId(int id) {
        this.id = id;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }

    public int getAppid() {
        return appid;
    }

    public String getImgurl() {
        return imgurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.appid);
        dest.writeString(this.imgurl);
    }

    public BannerBean() {
    }

    protected BannerBean(Parcel in) {
        this.id = in.readInt();
        this.appid = in.readInt();
        this.imgurl = in.readString();
    }

    public static final Creator<BannerBean> CREATOR = new Creator<BannerBean>() {
        public BannerBean createFromParcel(Parcel source) {
            return new BannerBean(source);
        }

        public BannerBean[] newArray(int size) {
            return new BannerBean[size];
        }
    };
}
