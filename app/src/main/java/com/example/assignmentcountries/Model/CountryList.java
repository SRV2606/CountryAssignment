package com.example.assignmentcountries.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CountryList implements Parcelable {


    public static final Creator<CountryList> CREATOR = new Creator<CountryList>() {
        @Override
        public CountryList createFromParcel(Parcel in) {
            return new CountryList(in);
        }

        @Override
        public CountryList[] newArray(int size) {
            return new CountryList[size];
        }
    };
    public static int pos = 0;
    @SerializedName("name")
    @Expose
    private String countryName;


//    @SerializedName("callingCodes")
//    @Expose
//    private String callingCodes;


    @SerializedName("capital")
    @Expose
    private String countryCapital;

    @SerializedName("region")
    @Expose
    private String countryRegion;

    @SerializedName("subregion")
    @Expose
    private String countrysubRegion;

    @SerializedName("population")
    @Expose
    private String countryPopulation;

    @SerializedName("currencies")
    @Expose
    private List<Currencyy> currencies = null;

    private int quantity = 0;


    public CountryList() {


    }

    public CountryList(Parcel in) {

//        this.callingCodes=in.readString();
        this.countryCapital = in.readString();
        this.countryName = in.readString();
        this.countryPopulation = in.readString();
        this.countryRegion = in.readString();
        this.countrysubRegion = in.readString();
        this.currencies = new ArrayList<>();

        in.readList(this.currencies, Currencyy.class.getClassLoader());
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

//    public String getCallingCodes() {
//        return callingCodes;
//    }
//
//    public void setCallingCodes(String callingCodes) {
//        this.callingCodes = callingCodes;
//    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getCountrysubRegion() {
        return countrysubRegion;
    }

    public void setCountrysubRegion(String countrysubRegion) {
        this.countrysubRegion = countrysubRegion;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(String countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public List<Currencyy> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currencyy> currencies) {
        this.currencies = currencies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.countryName);
        dest.writeString(this.countryCapital);
//        dest.writeValue(this.callingCodes);
        dest.writeString(this.countryPopulation);
        dest.writeString(this.countryRegion);
        dest.writeString(this.countrysubRegion);
        dest.writeList(this.currencies);
    }
}
