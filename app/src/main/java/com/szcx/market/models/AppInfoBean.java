package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by C on 8/12/2015.
 */
public class AppInfoBean implements Parcelable {
    /**
     * id : 84
     * name : 美颜相机
     * ver : 3.4.0
     * dmc : 1000
     * icon : http://m1.15ve.com/cpimage/20151208/115611.png
     * time : 2015/12/8 11:57:52
     * size : 22345154
     * dal : 软件介绍 美图秀秀荣誉出品，专为自拍研发的app！ 众多明星强力推荐, 自拍品牌全球第一！ AngelaBaby倾情代言, 和女神一起颜值UP！ 效果最自然的自拍神器，一秒拥有好气色！ 美颜相机是一个自拍App，可以一秒变美，效果超自然！爱美的你还不快来试试！ 1.一键美颜！精致容颜立即呈现 自拍必备！超简单的傻瓜式操作，完美修饰细节，即刻拥有极致美颜！ 2.超正哦！自拍拥有好气色 美白、补光、眼睛美化、脸部修饰，一秒全搞定。7个美颜级别，不管素颜或带妆，都能够量身打造你的美丽！ 3.一秒上妆！素颜也有自然妆容 素颜自拍，超服帖妆容瞬间呈现。性感、率真、honey各种妆感随心换！ 4.百变特效！专为自拍设计的滤镜 美图团队专为自拍而研发的滤镜，梦幻，浪漫，个性~ 5.照样美！夜拍自动补光 超强夜间自拍功能！自动美化光线，全面降噪，昏暗环境也能轻松打造夜美人！ 6.电影柔焦！打造视觉大片 唯美的“电影柔焦”特效，柔化背景，梦幻光线，艺术感十足，让你成为照片里最美的焦点！ 7.视频自拍也能美美哒 全球领先的“视频自拍”美颜技术， 时刻捕捉动态美，360度完美呈现，水嫩肌肤美美哒！
     * typeid : 2
     * pkg : com.meitu.meiyancamera
     * typename : 系统工具
     * ver2 : 1
     */

    private int id;
    private String name;
    private String ver;
    private int dmc;
    private String icon;
    private String time;
    private int size;
    private String dal;
    private int typeid;
    private String pkg;
    private int ver2;
    private String typename;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

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

    public void setDal(String dal) {
        this.dal = dal;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
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

    public String getDal() {
        return dal;
    }

    public int getTypeid() {
        return typeid;
    }

    public String getPkg() {
        return pkg;
    }

    public int getVer2() {
        return ver2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.ver);
        dest.writeInt(this.dmc);
        dest.writeString(this.icon);
        dest.writeString(this.time);
        dest.writeInt(this.size);
        dest.writeString(this.dal);
        dest.writeInt(this.typeid);
        dest.writeString(this.pkg);
        dest.writeInt(this.ver2);
        dest.writeString(this.typename);
    }

    public AppInfoBean() {
    }

    protected AppInfoBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.ver = in.readString();
        this.dmc = in.readInt();
        this.icon = in.readString();
        this.time = in.readString();
        this.size = in.readInt();
        this.dal = in.readString();
        this.typeid = in.readInt();
        this.pkg = in.readString();
        this.ver2 = in.readInt();
        this.typename = in.readString();
    }

    public static final Creator<AppInfoBean> CREATOR = new Creator<AppInfoBean>() {
        public AppInfoBean createFromParcel(Parcel source) {
            return new AppInfoBean(source);
        }

        public AppInfoBean[] newArray(int size) {
            return new AppInfoBean[size];
        }
    };
}
