package com.example.mypokemonapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityDetailBinding;
import com.example.mypokemonapp.databinding.ActivityLoginBinding;
import com.example.mypokemonapp.model.Pokemon;


public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        initData();
        listenerTheEvent();
    }

    private void listenerTheEvent() {
        binding.imgBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("mmm");
        Pokemon pokemon = (Pokemon) bundle.getSerializable("kkk");
        binding.setPokemon(pokemon);
    }
}