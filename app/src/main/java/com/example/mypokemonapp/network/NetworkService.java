package com.example.mypokemonapp.network;


import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.model.UserPokemon;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkService {

    // user
    @GET("user/all")
    Observable<List<User>> getAllUser();

    @POST("user/add")
    Observable<User> insertOrUpdateUser(@Body User user);

    // user-pokemon
    @GET("user-pokemon/all")
    Observable<List<UserPokemon>> getAllUserPokemon();


    @POST("user-pokemon/add")
    Observable<UserPokemon> insertOrUpdateUserPokemon(@Body UserPokemon userPokemon);

    // pokemon
    @GET("pokemon/all")
    Observable<List<Pokemon>> getAllPokemon();

}
