package com.example.mypokemonapp.repository;



import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.network.DatabaseService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class UserRepository {

    private DatabaseService services;

    @Inject
    public UserRepository(DatabaseService services) {
        this.services = services;
    }

    public Observable<List<User>> getAllUser() {
        return services.getAllUser();
    }

    public Observable<User> insertAUser(User user) {
        return services.insertAUser(user);
    }


}
