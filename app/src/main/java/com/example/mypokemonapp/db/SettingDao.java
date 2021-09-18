package com.example.mypokemonapp.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mypokemonapp.model.Setting;

import java.util.List;

@Dao
public interface SettingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insetSetting(Setting setting);

    @Update
    void updateSetting(Setting setting);

    @Delete
    void deleteSetting(Setting setting);

    @Query("SELECT * FROM setting_table")
    LiveData<List<Setting>> getAllSettingFromLocalDatabase();
}
