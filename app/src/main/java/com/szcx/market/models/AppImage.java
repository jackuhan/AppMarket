package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by C on 8/12/2015.
 */
public class AppImage implements Parcelable {
    /**
     * url : http://m1.15ve.com/cpimage/20151208/115636.jpg
     */
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
    }

    public AppImage() {
    }

    protected AppImage(Parcel in) {
        this.url = in.readString();
    }

    public static final Creator<AppImage> CREATOR = new Creator<AppImage>() {
        public AppImage createFromParcel(Parcel source) {
            return new AppImage(source);
        }

        public AppImage[] newArray(int size) {
            return new AppImage[size];
        }
    };
}
