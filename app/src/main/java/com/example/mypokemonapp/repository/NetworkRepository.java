package com.example.mypokemonapp.repository;


import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.network.NetworkService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class NetworkRepository {

    private NetworkService services;

    @Inject
    public NetworkRepository(NetworkService services) {
        this.services = services;
    }

    //user
    public Observable<List<User>> getAllUser() {
        return services.getAllUser();
    }

    public Observable<User> insertOrUpdateUser(User user) {
        return services.insertOrUpdateUser(user);
    }

    //user pokemon
    public Observable<List<UserPokemon>> getAllUserPokemonFromServer() {
        return services.getAllUserPokemon();
    }

    public Observable<UserPokemon> insertOrUpdateUserPokemon(UserPokemon userPokemon) {
        return services.insertOrUpdateUserPokemon(userPokemon);
    }

    // pokemon
    public Observable<List<Pokemon>> getAllPokemon() {
        return services.getAllPokemon();
    }

}
