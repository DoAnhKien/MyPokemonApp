package com.example.mypokemonapp.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.AppDatabaseRepository;

import java.util.List;

public class SettingViewModel extends ViewModel {

    private AppDatabaseRepository appDatabaseRepository;

    @ViewModelInject
    public SettingViewModel(AppDatabaseRepository appDatabaseRepository) {
        this.appDatabaseRepository = appDatabaseRepository;
    }

    void insertUser(User user){
        appDatabaseRepository.deleteAllLocalUser();
        appDatabaseRepository.insertLocalDatabase(user);
    }

}
