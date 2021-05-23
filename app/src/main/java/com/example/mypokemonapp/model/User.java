package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


public class User {

    @SerializedName("userId")
    @Expose
    private Integer userId;
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

    public User() {
    }


    public User(Integer userId, String userEmail, String userName, String userPassword, String userPermission) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPermission = userPermission;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) &&
                userEmail.equals(user.userEmail) &&
                userName.equals(user.userName) &&
                userPassword.equals(user.userPassword) &&
                userPermission.equals(user.userPermission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmail, userName, userPassword, userPermission);
    }
}