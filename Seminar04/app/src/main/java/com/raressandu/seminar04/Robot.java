package com.raressandu.seminar04;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Robot implements Parcelable {
    String name;
    Boolean isSmart;
    Date lastTimeActive;
    String softBytes;

    public Robot(String name, Boolean isSmart, Date lastTimeActive, String softBytes) {
        this.name = name;
        this.isSmart = isSmart;
        this.lastTimeActive = lastTimeActive;
        this.softBytes = softBytes;
    }

    public Robot() {

    }

    protected Robot(Parcel in) {
        name = in.readString();
        lastTimeActive=(java.util.Date) in.readSerializable();
        byte tmpIsSmart = in.readByte();
        isSmart = tmpIsSmart == 0 ? null : tmpIsSmart == 1;
        softBytes = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeSerializable(lastTimeActive);
        dest.writeByte((byte) (isSmart == null ? 0 : isSmart ? 1 : 2));
        dest.writeString(softBytes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Robot> CREATOR = new Creator<Robot>() {
        @Override
        public Robot createFromParcel(Parcel in) {
            return new Robot(in);
        }

        @Override
        public Robot[] newArray(int size) {
            return new Robot[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSmart() {
        return isSmart;
    }

    public void setSmart(Boolean smart) {
        isSmart = smart;
    }

    public Date getLastTimeActive() {
        return lastTimeActive;
    }

    public void setLastTimeActive(Date lastTimeActive) {
        this.lastTimeActive = lastTimeActive;
    }

    public String getSoftBytes() {
        return softBytes;
    }

    public void setSoftBytes(String softBytes) {
        this.softBytes = softBytes;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", isSmart=" + isSmart +
                ", lastTimeActive=" + lastTimeActive +
                ", softBytes='" + softBytes + '\'' +
                '}';
    }
}
