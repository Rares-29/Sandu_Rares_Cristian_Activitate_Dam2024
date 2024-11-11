package com.raressandu.prepareforexam01;

import android.os.Parcel;
import android.os.Parcelable;

public class Coffee implements Parcelable {

    String denumire;
    Double price;
    Boolean cafeina;

    public Coffee(String denumire, Double price, Boolean cafeina) {
        this.denumire = denumire;
        this.price = price;
        this.cafeina = cafeina;
    }

    protected Coffee(Parcel in) {
        denumire = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        byte tmpCafeina = in.readByte();
        cafeina = tmpCafeina == 0 ? null : tmpCafeina == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denumire);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
        dest.writeByte((byte) (cafeina == null ? 0 : cafeina ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Coffee> CREATOR = new Creator<Coffee>() {
        @Override
        public Coffee createFromParcel(Parcel in) {
            return new Coffee(in);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Double getPrice() {
        return price;
    }



    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getCafeina() {
        return cafeina;
    }

    public void setCafeina(Boolean cafeina) {
        this.cafeina = cafeina;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "denumire='" + denumire + '\'' +
                ", price=" + price +
                ", cafeina=" + cafeina +
                '}';
    }
}
