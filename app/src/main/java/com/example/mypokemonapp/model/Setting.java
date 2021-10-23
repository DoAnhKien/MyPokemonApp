package com.example.mypokemonapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "setting_table")
public class Setting implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "setting_id")
    private int settingId;
    @ColumnInfo(name = "setting_content")
    private String settingContent;

    public Setting() {
    }

    public Setting(int settingId, String settingContent) {
        this.settingId = settingId;
        this.settingContent = settingContent;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public String getSettingContent() {
        return settingContent;
    }

    public void setSettingContent(String settingContent) {
        this.settingContent = settingContent;
    }
}
