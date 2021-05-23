package com.example.mypokemonapp.network;



import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.User;

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
    Observable<User> insertAUser(@Body User user);


    // pokemon

    @GET("pokemon/all")
    Observable<List<Pokemon>> getAllPokemon();

}
