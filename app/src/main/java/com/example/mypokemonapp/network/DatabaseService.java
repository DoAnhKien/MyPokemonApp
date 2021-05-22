package com.example.mypokemonapp.network;



import com.example.mypokemonapp.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DatabaseService {

    @GET("user/all")
    Observable<List<User>> getAllUser();

    @POST("user/add")
    Observable<User> insertAUser(@Body User user);
}
