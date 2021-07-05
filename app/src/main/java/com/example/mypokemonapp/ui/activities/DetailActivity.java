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


    private void sendEmail() {
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"doanhkien001@gmail.com"});
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Xac thuc gmail");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent.createChooser(mailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }
}