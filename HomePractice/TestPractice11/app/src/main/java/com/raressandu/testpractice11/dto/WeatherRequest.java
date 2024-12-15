package com.raressandu.testpractice11.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherRequest implements Parcelable {

    double longitude;
    double latitude;

    public WeatherRequest(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    protected WeatherRequest(Parcel in) {
        longitude = in.readDouble();
        latitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherRequest> CREATOR = new Creator<WeatherRequest>() {
        @Override
        public WeatherRequest createFromParcel(Parcel in) {
            return new WeatherRequest(in);
        }

        @Override
        public WeatherRequest[] newArray(int size) {
            return new WeatherRequest[size];
        }
    };

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
