package com.example.mypokemonapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;


import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityLoginBinding;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private ActivityLoginBinding binding;
    private List<User> users;
    public static UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        initViews();
        observeData();
    }

    private void observeData() {
        viewModel.getLoginState().observe(this, errorLogin -> {
            switch (errorLogin) {
                case CAN_NOT_EMPTY:
                    Toast.makeText(this, "Không được để trống thông tin", Toast.LENGTH_SHORT).show();
                    break;
                case USER_NOT_EXIST:
                    Toast.makeText(this, "Tài khoản hoặc mật khẩu không tồn tại", Toast.LENGTH_SHORT).show();
                    break;
                case ADMIN_ACCESS:
                    startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                    finish();
                    break;
                case WORKER_ACCESS:
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    break;
            }

        });
    }

    private void initViews() {
        users = new ArrayList<>();
        binding.btnLogin.setOnClickListener(this);
        binding.btnRegister.setOnClickListener(this);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getAllUser().observe(this, users1 -> {
            users.clear();
            users.addAll(users1);
        });
        viewModel.getAllUserOnServer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                checkForLogin();
                break;
            case R.id.btnRegister:
                resetDataAndStartActivity();
                break;
        }
    }

    private void resetDataAndStartActivity() {
        binding.edtUserName.setText("");
        binding.edtUserPassword.setText("");
        startActivity(new Intent(LoginActivity.this, RegisterAccountActivity.class));
    }

    private void checkForLogin() {
        viewModel.checkForLogin(users, binding.edtUserName.getText().toString(), binding.edtUserPassword.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getAllUserOnServer();
    }
}