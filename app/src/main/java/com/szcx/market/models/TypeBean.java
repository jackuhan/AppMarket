package com.szcx.market.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by C on 8/12/2015.
 */
public class TypeBean implements Parcelable {
    /**
     * id : 1
     * typename : 系统工具
     */

    private int id;
    private String typename;

    public void setId(int id) {
        this.id = id;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getId() {
        return id;
    }

    public String getTypename() {
        return typename;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.typename);
    }

    public TypeBean() {
    }

    protected TypeBean(Parcel in) {
        this.id = in.readInt();
        this.typename = in.readString();
    }

    public static final Creator<TypeBean> CREATOR = new Creator<TypeBean>() {
        public TypeBean createFromParcel(Parcel source) {
            return new TypeBean(source);
        }

        public TypeBean[] newArray(int size) {
            return new TypeBean[size];
        }
    };
}
