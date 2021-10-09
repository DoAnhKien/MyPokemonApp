package com.example.mypokemonapp.ui.admin;


import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.AppDatabaseRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AdminViewModel extends ViewModel {

    private AppDatabaseRepository appDatabaseRepository;
    private MutableLiveData<List<Report>> mReports = new MutableLiveData<>();
    private MutableLiveData<List<FeedBack>> mFeedBacks = new MutableLiveData<>();

    @ViewModelInject
    public AdminViewModel(AppDatabaseRepository appDatabaseRepository) {
        this.appDatabaseRepository = appDatabaseRepository;
    }

    public MutableLiveData<List<Report>> getmReports(){
        return mReports;
    }

    public MutableLiveData<List<FeedBack>> getmFeedBacks(){
        return mFeedBacks;
    }

    public void requestAllReportsInServer(){
        appDatabaseRepository.getAllReport().
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(reports -> {
                    mReports.postValue(reports);
                }, error -> {
                    Log.d("KienDA", "requestAllFeedBackInServer: " + error.toString());
                });
    }

    public void requestAllFeedBackInServer(){
        appDatabaseRepository.getAllFeedBack().
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(feedBacks -> {
                    mFeedBacks.postValue(feedBacks);
                }, error -> {
                    Log.d("KienDA", "requestAllFeedBackInServer: " + error.toString());
                });
    }

    public void insertOrUpdateAReport(FeedBack feedBack) {
        appDatabaseRepository.insertOrUpdateFeedBack(feedBack).
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



