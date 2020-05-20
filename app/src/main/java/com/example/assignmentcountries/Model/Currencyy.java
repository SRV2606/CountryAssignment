package com.example.assignmentcountries.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currencyy implements Parcelable {


    public static final Creator<Currencyy> CREATOR = new Creator<Currencyy>() {
        @Override
        public Currencyy createFromParcel(Parcel in) {
            return new Currencyy(in);
        }

        @Override
        public Currencyy[] newArray(int size) {
            return new Currencyy[size];
        }
    };


    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("symbol")
    @Expose
    private String symbol;


    public Currencyy() {

    }

    public Currencyy(Parcel in) {
        this.code = in.readString();
        this.name = in.readString();
        this.symbol = in.readString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.name);
        dest.writeString(this.symbol);
    }
}
