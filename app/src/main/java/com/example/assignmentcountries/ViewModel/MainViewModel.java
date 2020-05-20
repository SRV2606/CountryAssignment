package com.example.countryassignment.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignmentcountries.Model.CountryList;
import com.example.assignmentcountries.Model.Repository;

import java.util.List;

public class MainViewModel extends ViewModel {


    private Repository mRepository;
    private LiveData<List<CountryList>> mData;


    public MainViewModel(Repository repository) {
        mRepository = repository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xxx", "data cleared");
    }

    public LiveData<List<CountryList>> mLiveData() {
        mData = mRepository.mLiveData();
        return mData;
    }

}
