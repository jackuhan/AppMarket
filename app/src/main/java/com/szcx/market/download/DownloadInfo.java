package com.szcx.market.download;

import com.lidroid.xutils.db.annotation.Transient;
import com.lidroid.xutils.http.HttpHandler;
import java.io.File;

/**
 * Author: wyouflf
 * Date: 13-11-10
 * Time: 下午8:11
 */
public class DownloadInfo {

  public DownloadInfo() {
  }

  private long id;

  @Transient private HttpHandler<File> handler;

  private HttpHandler.State state;

  private String downloadUrl;

  private String fileName;

  private String fileSavePath;

  private String image;//

  //版本号，用作apk文件名字符串之一
  private String version;//

  private long progress;

  private long fileLength;

  private boolean autoResume;

  private boolean autoRename;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public HttpHandler<File> getHandler() {
    return handler;
  }

  public void setHandler(HttpHandler<File> handler) {
    this.handler = handler;
  }

  public HttpHandler.State getState() {
    return null == state ? HttpHandler.State.LOADING : state;
  }

  public void setState(HttpHandler.State state) {
    this.state = state;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public String getimage() {
    return image;
  }

  public void setimage(String image) {
    this.image = image;
  }

  public String getversion() {
    return version;
  }

  public void setversion(String version) {
    this.version = version;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileSavePath() {
    return fileSavePath;
  }

  public void setFileSavePath(String fileSavePath) {
    this.fileSavePath = fileSavePath;
  }

  public long getProgress() {
    return progress;
  }

  public void setProgress(long progress) {
    this.progress = progress;
  }

  public long getFileLength() {
    return fileLength;
  }

  public void setFileLength(long fileLength) {
    this.fileLength = fileLength;
  }

  public boolean isAutoResume() {
    return autoResume;
  }

  public void setAutoResume(boolean autoResume) {
    this.autoResume = autoResume;
  }

  public boolean isAutoRename() {
    return autoRename;
  }

  public void setAutoRename(boolean autoRename) {
    this.autoRename = autoRename;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DownloadInfo)) return false;

    DownloadInfo that = (DownloadInfo) o;

    if (id != that.id) return false;

    return true;
  }

  @Override public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }

  @Override public String toString() {
    return "DownloadInfo{" +
        "id=" + id +
        ", handler=" + handler +
        ", state=" + state +
        ", downloadUrl='" + downloadUrl + '\'' +
        ", fileName='" + fileName + '\'' +
        ", fileSavePath='" + fileSavePath + '\'' +
        ", image='" + image + '\'' +
        ", version='" + version + '\'' +
        ", progress=" + progress +
        ", fileLength=" + fileLength +
        ", autoResume=" + autoResume +
        ", autoRename=" + autoRename +
        '}';
  }
}
