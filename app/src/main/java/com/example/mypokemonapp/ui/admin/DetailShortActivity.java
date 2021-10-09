package com.example.mypokemonapp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.databinding.ActivityDetailReportBinding;
import com.example.mypokemonapp.databinding.ActivityDetailShortBinding;

public class DetailShortActivity extends AppCompatActivity {

    private ActivityDetailShortBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_short);
        initDataForViews();
    }

    private void initDataForViews() {
        Intent intent = getIntent();
        binding.tvPersonSend.setText("Person send: "+ intent.getStringExtra("KienDAB"));
        binding.tvContent.setText(intent.getStringExtra("KienDAA"));
    }
}