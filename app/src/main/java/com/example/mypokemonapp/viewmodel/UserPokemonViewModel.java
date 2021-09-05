package com.example.mypokemonapp.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.repository.NetworkRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserPokemonViewModel extends ViewModel {

    private NetworkRepository repository;
    private MutableLiveData<List<Pokemon>> mPokemon = new MutableLiveData<>();
    private MutableLiveData<List<UserPokemon>> mUserPokemon = new MutableLiveData<>();
    private MutableLiveData<Pokemon> currentPokemon = new MutableLiveData<>();
    private String TAG = "KienDA";

    @ViewModelInject
    public UserPokemonViewModel(NetworkRepository networkRepository) {
        this.repository = networkRepository;
    }


    public LiveData<Pokemon> getCurrentPokemon() {
        return currentPokemon;
    }

    public MutableLiveData<List<Pokemon>> getmPokemon() {
        return mPokemon;
    }

    public MutableLiveData<List<UserPokemon>> getmUserPokemon() {
        return mUserPokemon;
    }

    public void getAllThePokemonFromServer() {
        repository.getAllPokemon().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(pokemons -> {
                    if (mPokemon.getValue() != null) {
                        if (mPokemon.getValue().size() != pokemons.size()) {
                            mPokemon.setValue(pokemons);
                        }
                    } else {
                        mPokemon.setValue(pokemons);
                    }
                }, error -> {


                });

    }

    public void findPokemonByPokemonName(String pokemonName) {
        repository.findPokemonByName(pokemonName).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(pokemon -> {
                    currentPokemon.postValue(pokemon);
                }, error -> {
                    Log.d(TAG, "findPokemonByPokemonName: " + error.toString());
                });
    }

    public void getAllTheUserPokemonFromServer() {
        repository.getAllUserPokemonFromServer().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userPokemons -> {
                    if (mUserPokemon.getValue() != null) {
                        if (mUserPokemon.getValue().size() != userPokemons.size()) {
                            mUserPokemon.setValue(userPokemons);
                        }
                    } else {
                        mUserPokemon.setValue(userPokemons);
                    }
                }, error -> {
                });
    }

    public void insertOrUpdateUserPokemon(UserPokemon userPokemon) {
        repository.insertOrUpdateUserPokemon(userPokemon).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userPokemons -> {

                }, error -> {

                });
    }

    public void deleteUserPokemon(int id) {
        repository.deleteUserPokemon(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(userPokemons -> {
                }, error -> {
                });
    }
}
