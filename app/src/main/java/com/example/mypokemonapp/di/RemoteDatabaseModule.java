package com.example.mypokemonapp.di;


import com.example.mypokemonapp.network.DatabaseService;
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
public class RemoteDatabaseModule {
    @Singleton
    @Provides
    public static Retrofit provideRemoteDatabaseModule() {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL_DATABASE)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public static DatabaseService provideDatabaseService(Retrofit retrofit) {
        return retrofit.create(DatabaseService.class);
    }
}
