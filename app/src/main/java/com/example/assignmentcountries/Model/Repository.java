package com.example.assignmentcountries.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.assignmentcountries.Network.RemoteNetworkCall;

import java.util.List;

public class Repository {


    private static final Object LOCK = new Object();
    private static Repository repository;
    private LiveData<List<CountryList>> mData;

    public Repository(Application application) {


        RemoteNetworkCall.fetchData();

    }

    public synchronized static Repository getInstance(Application application) {
        if (repository == null) {
            synchronized (LOCK) {
                repository = new Repository(application);
            }
        }
        return repository;
    }

    public LiveData<List<CountryList>> mLiveData() {
        mData = RemoteNetworkCall.getInit();

        return mData;
    }


}
