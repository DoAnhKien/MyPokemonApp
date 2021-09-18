package com.example.mypokemonapp.repository;


import androidx.lifecycle.LiveData;

import com.example.mypokemonapp.db.SettingDao;
import com.example.mypokemonapp.db.UserDao;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.Setting;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.network.NetworkService;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class AppDatabaseRepository {

    private NetworkService networkService;
    private UserDao userDao;
    private SettingDao settingDao;

    @Inject
    public AppDatabaseRepository(NetworkService networkService, UserDao userDao, SettingDao settingDao) {
        this.networkService = networkService;
        this.userDao = userDao;
        this.settingDao = settingDao;
    }

    //user

    public Observable<List<User>> getAllUser() {
        return networkService.getAllUser();
    }

    public Observable<User> insertOrUpdateUser(User user) {
        return networkService.insertOrUpdateUser(user);
    }

    public Observable<User> updateUser(User user) {
        return networkService.updateUer(user);
    }

    public Observable<User> deleteUserById(int id) {
        return networkService.deleteUserById(id);
    }

    //user pokemon

    public Observable<List<UserPokemon>> getAllUserPokemonFromServer() {
        return networkService.getAllUserPokemon();
    }

    public Observable<UserPokemon> insertOrUpdateUserPokemon(UserPokemon userPokemon) {
        return networkService.insertOrUpdateUserPokemon(userPokemon);
    }

    public Observable<UserPokemon> deleteUserPokemon(int id) {
        return networkService.deleteUserPokemon(id);
    }

    // pokemon

    public Observable<List<Pokemon>> getAllPokemon() {
        return networkService.getAllPokemon();
    }

    public Observable<Pokemon> findPokemonByName(String pokemonName) {
        return networkService.findPokemonByPokemonName(pokemonName);
    }

    // user offline

    // User local database
    public LiveData<List<User>> getAllUserFromLocalDatabase() {
        return userDao.getAllUserLocalDatabase();
    }

    public void insertLocalDatabase(User user) {
        userDao.insertAUSer(user);
    }

    public void insertSettingDatabase(Setting setting) {
        settingDao.insetSetting(setting);
    }


}
