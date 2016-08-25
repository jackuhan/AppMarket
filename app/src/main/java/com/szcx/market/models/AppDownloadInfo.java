package com.szcx.market.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.szcx.market.R;

/**
 * Created by C on 9/12/2015.
 */
public class AppDownloadInfo implements Parcelable {

    public static final int STATUS_NOT_DOWNLOAD = 0;
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_CONNECT_ERROR = 2;
    public static final int STATUS_DOWNLOADING = 3;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_DOWNLOAD_ERROR = 5;
    public static final int STATUS_COMPLETE = 6;
    public static final int STATUS_INSTALLED = 7;

    private String name;
    private String packageName;
    private int id;
    private String image;
    private String url;
    private int progress;
    private String downloadPerSize;
    private int status;
    //版本号，用作apk文件名字符串之一
    private String version;

    public AppDownloadInfo() {
    }

    public AppDownloadInfo(int id, String name, String packageName, String image, String url, String version) {
        this.id = id;
        this.name = name;
        this.packageName = packageName;
        this.image = image;
        this.url = url;
        this.status = AppDownloadInfo.STATUS_NOT_DOWNLOAD;
        this.version = version;
    }

    public AppDownloadInfo(int id, String name, String packageName, String image, String url, int status, String version) {
        this.id = id;
        this.name = name;
        this.packageName = packageName;
        this.image = image;
        this.url = url;
        this.status = status;
        this.version = version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownloadPerSize() {
        return downloadPerSize;
    }

    public void setDownloadPerSize(String downloadPerSize) {
        this.downloadPerSize = downloadPerSize;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusText(Context context) {
        switch (status) {
            case STATUS_NOT_DOWNLOAD:
                return context.getString(R.string.not_download);
            case STATUS_CONNECTING:
                return context.getString(R.string.connecting);
            case STATUS_CONNECT_ERROR:
                return context.getString(R.string.connect_error);
            case STATUS_DOWNLOADING:
                return context.getString(R.string.downloading);
            case STATUS_PAUSED:
                return context.getString(R.string.pause);
            case STATUS_DOWNLOAD_ERROR:
                return context.getString(R.string.download_error);
            case STATUS_COMPLETE:
                return context.getString(R.string.complete);
            case STATUS_INSTALLED:
                return context.getString(R.string.installed);
            default:
                return context.getString(R.string.not_download);
        }
    }

    public String getButtonText(Context context) {
        switch (status) {
            case STATUS_NOT_DOWNLOAD:
                return context.getString(R.string.download);
            case STATUS_CONNECTING:
                return context.getString(R.string.cancel);
            case STATUS_CONNECT_ERROR:
                return context.getString(R.string.try_again);
            case STATUS_DOWNLOADING:
                return context.getString(R.string.pause);
            case STATUS_PAUSED:
                return context.getString(R.string.resume);
            case STATUS_DOWNLOAD_ERROR:
                return context.getString(R.string.try_again);
            case STATUS_COMPLETE:
                return context.getString(R.string.install);
            case STATUS_INSTALLED:
                return context.getString(R.string.uninstall);
            default:
                return context.getString(R.string.download);
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.packageName);
        dest.writeInt(this.id);
        dest.writeString(this.image);
        dest.writeString(this.url);
        dest.writeInt(this.progress);
        dest.writeString(this.downloadPerSize);
        dest.writeInt(this.status);

        dest.writeString(this.version);
    }

    protected AppDownloadInfo(Parcel in) {
        this.name = in.readString();
        this.packageName = in.readString();
        this.id = in.readInt();
        this.image = in.readString();
        this.url = in.readString();
        this.progress = in.readInt();
        this.downloadPerSize = in.readString();
        this.status = in.readInt();

        this.version = in.readString();
    }

    public static final Creator<AppDownloadInfo> CREATOR = new Creator<AppDownloadInfo>() {
        public AppDownloadInfo createFromParcel(Parcel source) {
            return new AppDownloadInfo(source);
        }

        public AppDownloadInfo[] newArray(int size) {
            return new AppDownloadInfo[size];
        }
    };
}
