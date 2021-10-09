package com.example.mypokemonapp.ui.getfeedback;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.databinding.ActivityGetFeedBackBinding;
import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;
import com.example.mypokemonapp.viewmodel.UserPokemonViewModel;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GetFeedBackActivity extends AppCompatActivity implements View.OnClickListener {

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
        switch (v.getId()) {
            case R.id.tvCancel:
                cancelActivity();
                return;
            case R.id.tvConfirm:
                confirmActivity();
                return;
        }
    }

    private void confirmActivity() {
        if (binding.edtContent.getText().toString().isEmpty()) {
            Toast.makeText(this, "Can't empty", Toast.LENGTH_SHORT).show();
            return;
        }
        viewModel.getAllUserInLocalDatabase().observe(this, users -> {
                    FeedBack feedBack = new FeedBack(0, users.get(0).getUserId(), String.valueOf(System.currentTimeMillis()), binding.edtContent.getText().toString());
                    viewModel.insertOrUpdateAReport(feedBack);
                    finish();
                }
        );

    }

    private void cancelActivity() {
        finish();
    }

}
