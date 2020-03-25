package com.example.myaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class People implements Parcelable {
    private String name;
    private int age;
    private boolean mGender;
    private Friend friend;

    private ArrayList<String> mJobs;
    private ArrayList<Friend> mFriends = new ArrayList<Friend>();

    protected People(Parcel in) {
        name = in.readString();
        age = in.readInt();
        mGender = in.readByte() != 0;
        // 读取对象需要提供一个类加载器去读取,因为写入的时候写入了类的相关信息
        friend = in.readParcelable(Friend.class.getClassLoader());

        mJobs = in.createStringArrayList();
        //对应writeTypeList
        mFriends = in.createTypedArrayList(Friend.CREATOR);
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte) (mGender ? 1 : 0));
        // 序列化对象的时候传入要序列化的对象和一个flag,这里的flag几乎都是0,除非标识当前对象需要作为返回值返回,不能立即释放资源
        dest.writeParcelable(friend, flags);
        dest.writeStringList(mJobs);
        dest.writeTypedList(mFriends);
    }
}
