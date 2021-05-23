package com.example.mypokemonapp.viewmodel;

import android.text.TextUtils;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mypokemonapp.aenum.LoginState;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.UserRepository;
import com.example.mypokemonapp.util.Const;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private MutableLiveData<List<User>> mListUser = new MutableLiveData<>();
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    private MutableLiveData<LoginState> loginState = new MutableLiveData<>();
    private String TAG = "kienda";

    @ViewModelInject
    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MutableLiveData<List<User>> getAllUser() {
        return mListUser;
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }


    public MutableLiveData<LoginState> getLoginState() {
        return loginState;
    }

    public void checkForLogin(List<User> users, String userName, String userPassword) {
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword)) {
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword) && user.getUserPermission().equals(Const.STRING_WORKER)) {
                    loginState.setValue(LoginState.WORKER_ACCESS);
                    return;
                } else if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword) && user.getUserPermission().equals(Const.STRING_ADMIN)) {
                    loginState.setValue(LoginState.ADMIN_ACCESS);
                    return;
                } else {

                }
            }
        } else if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPassword)) {
            loginState.setValue(LoginState.CAN_NOT_EMPTY);
        }
        loginState.setValue(LoginState.USER_NOT_EXIST);
    }


    public void getAllUserOnServer() {
        userRepository.getAllUser().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(users -> {
                    mListUser.postValue(users);
                    Log.d("kienda", users.size() + "");
                }, error -> {
                    error.printStackTrace();
                });
    }

    public void insertAUser(String userEmail, String userName, String userPassword, String userRetypePassword) {
        Log.d(TAG, "insertAUser: ");
        if (!TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword) && !TextUtils.isEmpty(userRetypePassword)) {
            User user = new User(null, userEmail, userName, userPassword, Const.STRING_WORKER);
            userRepository.insertAUser(user)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user1 -> {
                        currentUser.postValue(user1);
                        Log.d(TAG, "insertAUser: " + "thanh cong");
                    }, error -> {
                        error.printStackTrace();
                        loginState.setValue(LoginState.USER_EXIST);
                        Log.d(TAG, "insertAUser: " + "that bai");
                    });
        } else {
            loginState.setValue(LoginState.USER_NULL);
        }
    }

}



