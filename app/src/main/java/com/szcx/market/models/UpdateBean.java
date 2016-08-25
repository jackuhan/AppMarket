package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by C on 7/1/2016.
 * Nukc
 */
public class UpdateBean implements Parcelable {

    /**
     * verid : 1
     * verstr : 1.0
     * upmsg : 优化加载速度
     * dmurl : /1.apk
     */

    private int verid;
    private String verstr;
    private String upmsg;
    private String dmurl;

    public void setVerid(int verid) {
        this.verid = verid;
    }

    public void setVerstr(String verstr) {
        this.verstr = verstr;
    }

    public void setUpmsg(String upmsg) {
        this.upmsg = upmsg;
    }

    public void setDmurl(String dmurl) {
        this.dmurl = dmurl;
    }

    public int getVerid() {
        return verid;
    }

    public String getVerstr() {
        return verstr;
    }

    public String getUpmsg() {
        return upmsg;
    }

    public String getDmurl() {
        return dmurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.verid);
        dest.writeString(this.verstr);
        dest.writeString(this.upmsg);
        dest.writeString(this.dmurl);
    }

    public UpdateBean() {
    }

    protected UpdateBean(Parcel in) {
        this.verid = in.readInt();
        this.verstr = in.readString();
        this.upmsg = in.readString();
        this.dmurl = in.readString();
    }

    public static final Creator<UpdateBean> CREATOR = new Creator<UpdateBean>() {
        public UpdateBean createFromParcel(Parcel source) {
            return new UpdateBean(source);
        }

        public UpdateBean[] newArray(int size) {
            return new UpdateBean[size];
        }
    };
}
