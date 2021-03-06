package com.example.mypokemonapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;


import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityRegisterAccountBinding;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegisterAccountBinding binding;
    private UserViewModel viewModel;
    private User currentUser;
    private List<User> arrUsers;
    private String TAG = "kienda";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_account);
        initViews();
        observeData();
    }

    private void initViews() {
        binding.btnSignUp.setOnClickListener(this);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        currentUser = new User();
        arrUsers = new ArrayList<>();
    }

    private void observeData() {
        viewModel.getCurrentUser().observe(this, user -> {
            Toast.makeText(this, "Đăng kí tải khoản thành công", Toast.LENGTH_SHORT).show();
            finish();
        });

        viewModel.getLoginState().observe(this, error -> {
            switch (error) {
                case USER_EXIST:
                    Toast.makeText(this, "Email này đã tồn tại", Toast.LENGTH_SHORT).show();
                    break;
                case USER_NULL:
                    Toast.makeText(this, "Không được để trống thông tin", Toast.LENGTH_SHORT).show();
                    break;
                case ERROR_GMAIL:
                    Toast.makeText(this, "Gmail không đúng định dạng", Toast.LENGTH_SHORT).show();
                    break;
                case ERROR_PASSWORD:
                    Toast.makeText(this, "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                    break;
            }
        });


    }



    private void sendEmail(String email) {
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Xac thuc gmail");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent.createChooser(mailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp:
                checkToLogin();
                break;
        }
    }

    private void checkToLogin() {
        Log.d(TAG, "checkToLogin: ");
        viewModel.insertOrUpdateAUser(binding.edtEmail.getText().toString(),
                binding.edtUserName.getText().toString(),
                binding.edtPassword.getText().toString(),
                binding.edtRetypePassword.getText().toString());
    }

}