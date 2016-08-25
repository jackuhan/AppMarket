package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by C on 7/1/2016.
 * Nukc
 */
public class NecessaryBean implements Parcelable {
  /**
   * statue : 0
   * msg : OK
   * name : 必备软件
   * msg1 : 必备软件2
   * img : http://m1.15ve.com/cpimage/20160106/bz.jpg
   * applist : [{"id":84,"name":"美颜相机","ver":"3.4.0","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/115611.png","time":"2015/12/8
   * 11:57:52","size":22345154,"pkg":"com.meitu.meiyancamera","ver2":1},{"id":83,"name":"美图秀秀","ver":"V4.8.0","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/114644.png","time":"2015/12/8
   * 11:49:12","size":43882905,"pkg":"com.mt.mtxx.mtxx","ver2":1},{"id":82,"name":"平安WiFi","ver":"3.5.4","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/114207.png","time":"2015/12/8
   * 11:43:48","size":8283750,"pkg":"com.pingan.pinganwifi","ver2":1},{"id":81,"name":"搜狗输入法","ver":"7.11","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/113726.png","time":"2015/12/8
   * 11:39:16","size":27902607,"pkg":"com.sohu.inputmethod.sogou","ver2":1},{"id":80,"name":"酷狗音乐","ver":"V7.9.9","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/113420.png","time":"2015/12/8
   * 11:35:41","size":23320330,"pkg":"com.kugou.android","ver2":1},{"id":79,"name":"搜狐视频","ver":"5.1.1","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/112907.png","time":"2015/12/8
   * 11:31:02","size":16871587,"pkg":"com.sohu.sohuvideo","ver2":1},{"id":78,"name":"爱奇艺视频","ver":"6.8.2","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/112545.png","time":"2015/12/8
   * 11:26:54","size":10789847,"pkg":"com.qiyi.video","ver2":1},{"id":77,"name":"腾讯视频","ver":"4.5.0.9698","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/112026.png","time":"2015/12/8
   * 11:23:06","size":21663580,"pkg":"com.tencent.qqlive","ver2":1},{"id":76,"name":"唱吧直播间","ver":"V1.5.1","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/111316.png","time":"2015/12/8
   * 11:23:25","size":32568770,"pkg":"com.changba.live","ver2":1},{"id":75,"name":"QQ音乐","ver":"V5.7.1.5","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/105940.jpg","time":"2015/12/8
   * 11:01:15","size":28416409,"pkg":"com.tencent.qqmusic","ver2":1},{"id":74,"name":"百度贴吧","ver":"V7.0.4","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/105445.png","time":"2015/12/8
   * 10:56:00","size":33942405,"pkg":"com.baidu.tieba","ver2":1},{"id":73,"name":"新浪微博","ver":"V5.6.0","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/104843.png","time":"2015/12/8
   * 10:50:06","size":41838182,"pkg":"com.sina.weibo","ver2":1},{"id":72,"name":"QQ空间","ver":"V6.0.1.288","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151208/103449.png","time":"2015/12/8
   * 10:43:11","size":20594032,"pkg":"com.qzone","ver2":1},{"id":71,"name":"QQ","ver":"6.0.1","dmc":1000,"icon":"http://m1.15ve.com/cpimage/20151207/170900.png","time":"2015/12/8
   * 10:42:27","size":28689039,"pkg":"com.tencent.mobileqq","ver2":1},{"id":70,"name":"微信","ver":"6.3.7.65_r060a025","dmc":1200,"icon":"http://m1.15ve.com/cpimage/20151207/161204.png","time":"2015/12/8
   * 10:42:48","size":32862371,"pkg":"com.tencent.mm","ver2":1}]
   */

  private int statue;
  private String msg;
  private String name;
  private String msg1;
  private String img;

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

  public List<AppInfoBean> getApplist() {
    return applist;
  }

  public void setApplist(List<AppInfoBean> applist) {
    this.applist = applist;
  }

  public void setStatue(int statue) {
    this.statue = statue;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMsg1(String msg1) {
    this.msg1 = msg1;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public int getStatue() {
    return statue;
  }

  public String getMsg() {
    return msg;
  }

  public String getName() {
    return name;
  }

  public String getMsg1() {
    return msg1;
  }

  public String getImg() {
    return img;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.statue);
    dest.writeString(this.msg);
    dest.writeString(this.name);
    dest.writeString(this.msg1);
    dest.writeString(this.img);
    dest.writeTypedList(applist);
  }

  public NecessaryBean() {
  }

  protected NecessaryBean(Parcel in) {
    this.statue = in.readInt();
    this.msg = in.readString();
    this.name = in.readString();
    this.msg1 = in.readString();
    this.img = in.readString();
    this.applist = in.createTypedArrayList(AppInfoBean.CREATOR);
  }

  public static final Creator<NecessaryBean> CREATOR = new Creator<NecessaryBean>() {
    public NecessaryBean createFromParcel(Parcel source) {
      return new NecessaryBean(source);
    }

    public NecessaryBean[] newArray(int size) {
      return new NecessaryBean[size];
    }
  };
}
