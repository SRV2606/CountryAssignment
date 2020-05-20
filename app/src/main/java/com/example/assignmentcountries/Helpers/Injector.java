package com.example.assignmentcountries.Helpers;

import android.app.Application;

import com.example.assignmentcountries.Model.Repository;
import com.example.assignmentcountries.ViewModel.MainViewModelFactory;


public class Injector {


    private static Repository provideRepository(Application context) {

        return Repository.getInstance(context);
    }

    public static MainViewModelFactory provideMainViewModelFactory(Application application) {
        Repository repository = provideRepository(application);
        return new MainViewModelFactory(repository);
    }
}
