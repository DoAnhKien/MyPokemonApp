package com.example.mypokemonapp.network;



import com.example.mypokemonapp.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokeApiService {
    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}