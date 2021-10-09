package com.example.mypokemonapp.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mypokemonapp.model.User;

import java.util.List;


@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAUSer(User user);

    @Update
    void updateAUser(User user);

    @Delete
    void deleteAUser(User user);

    @Query("DELETE FROM user_table")
    void deleteAllUser();

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUserLocalDatabase();
}
