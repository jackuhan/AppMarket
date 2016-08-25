package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by C on 8/12/2015.
 */
public class AppListBean implements Parcelable {
    /**
     * statue : 0
     * msg : OK
     */

    private int statue;
    private String msg;
    /**
     * id : 84
     * name : 美颜相机
     * ver : 3.4.0
     * dmc : 1000
     * icon : http://m1.15ve.com/cpimage/20151208/115611.png
     * time : 2015/12/8 11:57:52
     * size : 22345154
     * pkg : com.meitu.meiyancamera
     * ver2 : 1
     */

    private List<AppInfoBean> applist;
    /**
     * id : 84
     * name : 美颜相机
     * ver : 3.4.0
     * dmc : 1000
     * icon : http://m1.15ve.com/cpimage/20151208/115611.png
     * time : 2015/12/8 11:57:52
     * size : 22345154
     * pkg : com.meitu.meiyancamera
     * ver2 : 1
     */

    private int id;
    private String name;
    private String ver;
    private int dmc;
    private String icon;
    private String time;
    private int size;
    private String pkg;
    private int ver2;

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setApplist(List<AppInfoBean> applist) {
        this.applist = applist;
    }

    public int getStatue() {
        return statue;
    }

    public String getMsg() {
        return msg;
    }

    public List<AppInfoBean> getApplist() {
        return applist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.statue);
        dest.writeString(this.msg);
        dest.writeList(this.applist);
    }

    public AppListBean() {
    }

    protected AppListBean(Parcel in) {
        this.statue = in.readInt();
        this.msg = in.readString();
        this.applist = new ArrayList<AppInfoBean>();
        in.readList(this.applist, List.class.getClassLoader());
    }

    public static final Creator<AppListBean> CREATOR = new Creator<AppListBean>() {
        public AppListBean createFromParcel(Parcel source) {
            return new AppListBean(source);
        }

        public AppListBean[] newArray(int size) {
            return new AppListBean[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public void setDmc(int dmc) {
        this.dmc = dmc;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public void setVer2(int ver2) {
        this.ver2 = ver2;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVer() {
        return ver;
    }

    public int getDmc() {
        return dmc;
    }

    public String getIcon() {
        return icon;
    }

    public String getTime() {
        return time;
    }

    public int getSize() {
        return size;
    }

    public String getPkg() {
        return pkg;
    }

    public int getVer2() {
        return ver2;
    }
}
