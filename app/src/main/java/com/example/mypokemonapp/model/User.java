package com.example.mypokemonapp.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.mypokemonapp.aenum.LoginState;
import com.example.mypokemonapp.util.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


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

    public boolean insertAUser(int currentUserId, String userEmail, String userName, String userPassword, String userRetypePassword) {
        User tempUserA = new User(1, "1", "1", "1", "1");
        User tempUserB = new User(2, "2", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        if (!userEmail.equals("") && !userName.equals("") && !userPassword.equals("") && !userRetypePassword.equals("")) {
            if (userPassword.equals(userRetypePassword)) {
                for (int i = 0; i < mUsers.size(); i++) {
                    if (mUsers.get(i).getUserEmail().equals(userEmail) || mUsers.get(i).getUserId() == currentUserId) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean findAUser(int userId) {
        User tempUserA = new User(1, "1", "1", "1", "1");
        User tempUserB = new User(2, "2", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        for (int i = 0; i < mUsers.size(); i++) {
            if (mUsers.get(i).getUserId() == userId) {
                return true;
            }
        }
        return false;
    }

    public boolean updateAUser(User user) {
        User tempUserA = new User(1, "1", "1", "1", "1");
        User tempUserB = new User(2, "2", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        for (int i = 0; i < mUsers.size(); i++) {
            if (mUsers.get(i).getUserId() == user.getUserId()) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteAUser(User user) {
        User tempUserA = new User(1, "1", "1", "1", "1");
        User tempUserB = new User(2, "2", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        for (int i = 0; i < mUsers.size(); i++) {
            if (mUsers.get(i).getUserId() == user.getUserId()) {
                return true;
            }
        }
        return false;
    }


}