package com.example.myaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

/***
 * 序列化的对象
 */
public class Friend implements Parcelable {
    private String name;
    private String address;
    private int age;
    public Friend(){
        super();
    }

    /**
     * 反序列化
     * @param in
     */
    protected Friend(Parcel in) {
        name = in.readString();
        address = in.readString();
        age = in.readInt();
    }

    /**
     * 序列化方法
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 提供一个CREATOR,创建Friend对象的实例
     */
    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };
}
