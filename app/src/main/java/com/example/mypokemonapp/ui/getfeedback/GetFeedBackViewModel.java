package com.example.mypokemonapp.ui.getfeedback;


import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mypokemonapp.aenum.LoginState;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.AppDatabaseRepository;
import java.util.List;

public class GetFeedBackViewModel extends ViewModel {

    private AppDatabaseRepository appDatabaseRepository;

    @ViewModelInject
    public GetFeedBackViewModel(AppDatabaseRepository appDatabaseRepository) {
        this.appDatabaseRepository = appDatabaseRepository;
    }




}



