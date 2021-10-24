package com.example.mypokemonapp.network;


import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.Report;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.model.UserPokemon;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NetworkService {
    // user
    @GET("user/all")
    Observable<List<User>> getAllUser();

    @POST("user/add")
    Observable<User> insertOrUpdateUser(@Body User user);

    @POST("user/update")
    Observable<User> updateUer(@Body User user);

    @POST("user/delete/{id}")
    Observable<User> deleteUserById(@Path("id") int id);

    // user-pokemon
    @GET("user-pokemon/all")
    Observable<List<UserPokemon>> getAllUserPokemon();

    @POST("user-pokemon/add")
    Observable<UserPokemon> insertOrUpdateUserPokemon(@Body UserPokemon userPokemon);

    @POST("user-pokemon/delete/{id}")
    Observable<UserPokemon> deleteUserPokemon(@Path("id") int id);

    // pokemon
    @GET("pokemon/all")
    Observable<List<Pokemon>> getAllPokemon();

    @GET("findPokemon/{pokemonName}")
    Observable<Pokemon> findPokemonByPokemonName(@Path("pokemonName") String pokemonName);

    // report
    @GET("report/all")
    Observable<List<Report>> getAllTheReport();

    @POST("report/add")
    Observable<Report> insertOrUpdateTheReport(@Body Report report);

    @POST("report/delete/{id}")
    Observable<Report> deleteReportById(@Path("id") int id);

    @POST("report/find/{userId}")
    Observable<Report> findUserReportByUserId(@Path("userId") int userId);

    // feed back
    @GET("feedback/all")
    Observable<List<FeedBack>> getAllTheFeedBack();

    @POST("feedback/add")
    Observable<FeedBack> insertOrUpdateTheReport(@Body FeedBack feedBack);

    @POST("feedback/delete/{id}")
    Observable<FeedBack> deleteFeedBackById(@Path("id") int id);

    @POST("feedback/find/{userId}")
    Observable<List<FeedBack>> findUserFeedBackByUserId(@Path("userId") int userId);
}
