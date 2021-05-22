package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userEmail")
    @Expose
    private String userEmail;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userPassword")
    @Expose
    private String userPassword;
    @SerializedName("userPermission")
    @Expose
    private String userPermission;
    @SerializedName("userKey")
    @Expose
    private String userKey;

    public User() {
    }

    public User(String userEmail, String userName, String userPassword, String userPermission, String userKey) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPermission = userPermission;
        this.userKey = userKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

}