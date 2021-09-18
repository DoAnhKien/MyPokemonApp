package com.example.mypokemonapp.di;


import android.app.Application;

import androidx.room.Room;

import com.example.mypokemonapp.db.AppDatabase;
import com.example.mypokemonapp.db.SettingDao;
import com.example.mypokemonapp.db.UserDao;
import com.example.mypokemonapp.model.Setting;
import com.example.mypokemonapp.network.NetworkService;
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
public class AppDatabaseModule {
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
    public static NetworkService provideDatabaseService(Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    public static AppDatabase providesAppDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),
                AppDatabase.class, Const.APP_DATABASE)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries() //FIXME remove later
                .build();

    }

    @Singleton
    @Provides
    public static UserDao providesUserDao(AppDatabase database) {
        return database.userDao();
    }

    @Singleton
    @Provides
    public static SettingDao providesSettingDao(AppDatabase database) {
        return database.settingDao();
    }

}
