package com.raressandu.testpractice12;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private Integer id;
    private String name;
    private Double weight;
    private boolean carnivor;

    public Animal(Integer id, String name, Double weight, boolean carnivor) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.carnivor = carnivor;
    }

    protected Animal(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            weight = null;
        } else {
            weight = in.readDouble();
        }
        carnivor = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        if (weight == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(weight);
        }
        dest.writeByte((byte) (carnivor ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public boolean isCarnivor() {
        return carnivor;
    }

    public void setCarnivor(boolean carnivor) {
        this.carnivor = carnivor;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", carnivor=" + carnivor +
                '}';
    }
}
