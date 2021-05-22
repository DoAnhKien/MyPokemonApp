package com.example.mypokemonapp.di;



import com.example.mypokemonapp.network.PokeApiService;
import com.example.mypokemonapp.util.Const;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {
    @Provides
    @Singleton
    public static PokeApiService providePokemonApiService() {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL_POKEMON)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(PokeApiService.class);
    }
}
