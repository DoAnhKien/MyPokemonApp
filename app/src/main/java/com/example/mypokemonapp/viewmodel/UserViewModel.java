package com.example.mypokemonapp.viewmodel;

import android.text.TextUtils;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mypokemonapp.aenum.LoginState;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.repository.AppDatabaseRepository;
import com.example.mypokemonapp.util.Const;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserViewModel extends ViewModel {

    private AppDatabaseRepository appDatabaseRepository;
    private MutableLiveData<List<User>> mListUser = new MutableLiveData<>();
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    private MutableLiveData<LoginState> loginState = new MutableLiveData<>();
    private MutableLiveData<User> userLogin = new MutableLiveData<>();
    private String TAG = "kienda";

    @ViewModelInject
    public UserViewModel(AppDatabaseRepository appDatabaseRepository) {
        this.appDatabaseRepository = appDatabaseRepository;
    }

    public MutableLiveData<List<User>> getAllUser() {
        return mListUser;
    }

    public MutableLiveData<User> getCurrentUser() {
        return currentUser;
    }

    public MutableLiveData<User> getUserLogin() {
        return userLogin;
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
                    userLogin.postValue(user);
                    return;
                } else if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword) && user.getUserPermission().equals(Const.STRING_ADMIN)) {
                    loginState.setValue(LoginState.ADMIN_ACCESS);
                    return;
                }
            }
        } else if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPassword)) {
            loginState.setValue(LoginState.CAN_NOT_EMPTY);
        }
        loginState.setValue(LoginState.USER_NOT_EXIST);
    }

    public void getAllUserOnServer() {
        appDatabaseRepository.getAllUser().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(users -> {
                    if (mListUser.getValue() != null) {
                        if (mListUser.getValue().size() != users.size()) {
                            mListUser.setValue(users);
                        }
                    } else {
                        mListUser.setValue(users);
                    }
                }, error -> {

                    Log.d(TAG, "getAllUserOnServer: " + error.toString());

                    error.printStackTrace();
                });
    }

    public void insertOrUpdateAUser(String userEmail, String userName, String userPassword, String userRetypePassword) {
        Log.d(TAG, "insertAUser: ");
        if (!TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword) && !TextUtils.isEmpty(userRetypePassword)) {
            if (userEmail.contains("@gmail.com")) {
                if (userPassword.equals(userRetypePassword)) {
                    User user = new User(null, userEmail, userName, userPassword, Const.STRING_WORKER);
                    appDatabaseRepository.insertOrUpdateUser(user)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(user1 -> {
                                currentUser.postValue(user1);
                            }, error -> {
                                Log.d(TAG, "insertOrUpdateAUser: " + error.toString());
                                error.printStackTrace();
                                loginState.setValue(LoginState.USER_EXIST);
                            });
                }
                loginState.setValue(LoginState.ERROR_PASSWORD);
                return;
            }
            loginState.setValue(LoginState.ERROR_GMAIL);
        } else {
            loginState.setValue(LoginState.USER_NULL);
        }
    }

    public void updateUser(int userId, String userEmail, String userName, String userPassword) {
        if (!TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword)) {
            Log.d(TAG, "updateUser: ");
            User user = new User(userId, userEmail, userName, userPassword, Const.STRING_WORKER);
            appDatabaseRepository.updateUser(user)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user1 -> {
                        currentUser.postValue(user1);
                    }, error -> {
                        Log.d(TAG, "000: " + error.toString());
                        error.printStackTrace();
                        loginState.setValue(LoginState.USER_EXIST);
                    });
            if (userEmail.contains("@gmail.com")) {

                return;
            }
            loginState.setValue(LoginState.ERROR_GMAIL);
        } else {
            loginState.setValue(LoginState.USER_NULL);
        }
    }

    public void insertAUserForLocalDatabase(User user) {
        appDatabaseRepository.insertLocalDatabase(user);
    }


    public void deleteUserById(int id) {
        appDatabaseRepository.deleteUserById(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(user -> {

                }, error -> {

                });
    }

}



