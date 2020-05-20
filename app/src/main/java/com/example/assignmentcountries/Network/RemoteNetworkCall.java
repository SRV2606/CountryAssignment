package com.example.assignmentcountries.Network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.assignmentcountries.Model.CountryList;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class RemoteNetworkCall {

    private static MutableLiveData<List<CountryList>> mMutableLiveData = new MutableLiveData<>();
    private static Observable<List<CountryList>> observable;
    private static CompositeDisposable com = new CompositeDisposable();


    public static void fetchData() {

        ApiServices services = NetworkAdapter.getRetrofitInstance().create(ApiServices.class);
//        observable = services.getCountryByName("united");
        // if want to do another query
        observable = services.getCountryList();
        com.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<CountryList>>() {
                    @Override
                    public void onNext(List<CountryList> orderDetails) {
                        mMutableLiveData.postValue(orderDetails);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));


    }

    public static LiveData<List<CountryList>> getInit() {

        return mMutableLiveData;
    }

}
