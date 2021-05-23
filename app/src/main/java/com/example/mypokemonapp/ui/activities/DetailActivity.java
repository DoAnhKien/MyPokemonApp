package com.example.mypokemonapp.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityDetailBinding;
import com.example.mypokemonapp.databinding.ActivityLoginBinding;


public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
    }
}