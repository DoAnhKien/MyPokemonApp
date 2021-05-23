package com.example.mypokemonapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.adapter.UserAdapter;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.databinding.ActivityDetailBinding;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AdminActivity extends AppCompatActivity {

    private ActivityAdminBinding binding;

    private UserViewModel viewModel;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin);
        initViews();
    }

    private void initViews() {
        adapter = new UserAdapter();

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getAllUser().observe(this, users1 -> {
            adapter.submitList(users1);
        });
        viewModel.getAllUserOnServer();
        binding.rvAdmin.setAdapter(adapter);
        binding.rvAdmin.setHasFixedSize(true);
    }
}