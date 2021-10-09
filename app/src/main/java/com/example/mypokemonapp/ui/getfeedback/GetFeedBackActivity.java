package com.example.mypokemonapp.ui.getfeedback;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.databinding.ActivityGetFeedBackBinding;
import com.example.mypokemonapp.viewmodel.UserPokemonViewModel;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GetFeedBackActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityGetFeedBackBinding binding;
    private GetFeedBackViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_get_feed_back);
        setOnClickForViews();
        initViewModels();
    }

    private void initViewModels() {
        viewModel = new ViewModelProvider(this).get(GetFeedBackViewModel.class);
    }

    private void setOnClickForViews() {
        binding.tvCancel.setOnClickListener(this);
        binding.tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

}
