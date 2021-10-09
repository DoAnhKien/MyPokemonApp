package com.example.mypokemonapp.ui.sendreport;


import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.AppDatabaseRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SendReportViewModel extends ViewModel {

    private AppDatabaseRepository appDatabaseRepository;

    @ViewModelInject
    public SendReportViewModel(AppDatabaseRepository appDatabaseRepository) {
        this.appDatabaseRepository = appDatabaseRepository;
    }

    public LiveData<List<User>> getAllUserInLocalDatabase() {
        return appDatabaseRepository.getAllUserFromLocalDatabase();
    }

    public void insertOrUpdateAReport(Report report) {
        appDatabaseRepository.insertOrUpdateReport(report).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(report1 -> {

                }, error -> {

                });
    }

    public void findAReport(int id) {
        appDatabaseRepository.findReportById(id).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(report1 -> {

                }, error -> {

                });
    }

    public void deleteAReport(int id) {
        appDatabaseRepository.deleteTheReport(id).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(report1 -> {

                }, error -> {

                });
    }
}



