package com.example.mypokemonapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mypokemonapp.model.Setting;
import com.example.mypokemonapp.model.User;


@Database(entities = {User.class, Setting.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract SettingDao settingDao();
}
