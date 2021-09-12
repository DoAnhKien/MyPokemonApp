package com.example.mypokemonapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityAddEditUserBinding;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddEditUserActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityAddEditUserBinding binding;
    private UserViewModel viewModel;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_user);
        initViews();
        setOnClickForViews();
    }

    private void setOnClickForViews() {
        binding.tvCancel.setOnClickListener(this);
        binding.tvConfirm.setOnClickListener(this);
    }

    private void initViews() {
        user = (User) getIntent().getBundleExtra("mmm").getSerializable("123");
        binding.setUser(user);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCancel:
                checkForCancel();
                break;
            case R.id.tvConfirm:
                checkForConfirm();
                break;
        }
    }

    private void checkForConfirm() {
        String userName = binding.userName.getText().toString();
        String userPassword = binding.userPassword.getText().toString();
        viewModel.updateUser(user.getUserId(), user.getUserEmail(), userName, userPassword);
        finish();
    }

    private void checkForCancel() {
        finish();
    }
}