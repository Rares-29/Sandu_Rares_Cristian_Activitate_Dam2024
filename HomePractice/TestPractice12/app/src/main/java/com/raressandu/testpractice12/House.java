package com.raressandu.testpractice12;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "house")
public class House implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    Integer id;
    double surface;
    String address;
    Integer price;

    Date dateAdded;

    public House(double surface, String address, Integer price, Date dateAdded) {
        this.surface = surface;
        this.address = address;
        this.price = price;
        this.dateAdded = dateAdded;
    }

    protected House(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        surface = in.readDouble();
        address = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readInt();
        }
        dateAdded = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeDouble(surface);
        dest.writeString(address);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(price);
        }
        dest.writeLong(dateAdded.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", surface=" + surface +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
