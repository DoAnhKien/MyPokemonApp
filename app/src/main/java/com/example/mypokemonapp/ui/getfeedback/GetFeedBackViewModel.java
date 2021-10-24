package com.example.mypokemonapp.ui.getfeedback;


import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mypokemonapp.aenum.LoginState;
import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.AppDatabaseRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GetFeedBackViewModel extends ViewModel {

    private AppDatabaseRepository appDatabaseRepository;
    private MutableLiveData<List<FeedBack>> currentReport = new MutableLiveData<>();

    @ViewModelInject
    public GetFeedBackViewModel(AppDatabaseRepository appDatabaseRepository) {
        this.appDatabaseRepository = appDatabaseRepository;
    }

    public MutableLiveData<List<FeedBack>> getCurrentFeedBack() {
        return currentReport;
    }

    public LiveData<List<User>> getAllUserInLocalDatabase() {
        return appDatabaseRepository.getAllUserFromLocalDatabase();
    }

    public void insertOrUpdateAFeedBack(FeedBack feedBack) {
        appDatabaseRepository.insertOrUpdateFeedBack(feedBack).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(report1 -> {

                }, error -> {

                });
    }

    public void findAFeedBack(int id) {
        appDatabaseRepository.findFeedBackById(id).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(feedback -> {
                    currentReport.postValue(feedback);
                }, error -> {

                });
    }

    public void deleteAFeedBack(int id) {
        appDatabaseRepository.deleteTheReport(id).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(report1 -> {

                }, error -> {

                });
    }


}



