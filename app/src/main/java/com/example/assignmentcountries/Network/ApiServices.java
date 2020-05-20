package com.example.assignmentcountries.Network;


import com.example.assignmentcountries.Model.CountryList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("all")
    Observable<List<CountryList>> getCountryList();

    @GET("name/{name}")
    Observable<List<CountryList>> getCountryByName(@Path("name") String name);

    // just showing that we can put more querry params as required to sort

}





