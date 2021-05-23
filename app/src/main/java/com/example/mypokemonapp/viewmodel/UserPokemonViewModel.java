package com.example.mypokemonapp.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.repository.NetworkRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserPokemonViewModel extends ViewModel {

    private NetworkRepository repository;
    private MutableLiveData<List<Pokemon>> mPokemon = new MutableLiveData<>();
    private String TAG = "UserPokemonViewModel";

    @ViewModelInject
    public UserPokemonViewModel(NetworkRepository networkRepository) {
        this.repository = networkRepository;
    }

    public MutableLiveData<List<Pokemon>> getmPokemon() {
        return mPokemon;
    }

    public void getAllThePokemonFromServer() {
        repository.getAllPokemon().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(pokemons -> {
                    mPokemon.postValue(pokemons);
                }, error -> {
                    Log.d(TAG, "getThePokemonFromServer: " + error.toString());
                });
    }
}
