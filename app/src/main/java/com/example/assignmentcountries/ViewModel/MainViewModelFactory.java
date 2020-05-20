package com.example.assignmentcountries.ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.assignmentcountries.Model.Repository;


public final class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final Repository mRepository;

    public MainViewModelFactory(Repository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked cast")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new com.example.countryassignment.ViewModel.MainViewModel(mRepository);
    }
}