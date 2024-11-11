package com.raressandu.prepareforexam02;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class AirlineTicket implements Parcelable {

    private String passengerName;
    private Date dateOfFlight;
    private String typeOfFlight;
    private Double price;

    public AirlineTicket(String passengerName, Date dateOfFlight, String typeOfFlight, Double price) {
        this.passengerName = passengerName;
        this.dateOfFlight = dateOfFlight;
        this.typeOfFlight = typeOfFlight;
        this.price = price;
    }


    protected AirlineTicket(Parcel in) {
        passengerName = in.readString();
        typeOfFlight = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        dateOfFlight = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(passengerName);
        dest.writeString(typeOfFlight);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
        dest.writeLong(dateOfFlight.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AirlineTicket> CREATOR = new Creator<AirlineTicket>() {
        @Override
        public AirlineTicket createFromParcel(Parcel in) {
            return new AirlineTicket(in);
        }

        @Override
        public AirlineTicket[] newArray(int size) {
            return new AirlineTicket[size];
        }
    };

    @Override
    public String toString() {
        return "AirlineTicket{" +
                "passengerName='" + passengerName + '\'' +
                ", dateOfFlight=" + dateOfFlight +
                ", typeOfFlight='" + typeOfFlight + '\'' +
                ", price=" + price +
                '}';
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public String getTypeOfFlight() {
        return typeOfFlight;
    }

    public void setTypeOfFlight(String typeOfFlight) {
        this.typeOfFlight = typeOfFlight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
