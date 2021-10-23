package com.example.mypokemonapp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityDetailShortBinding;
import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.ui.getfeedback.GetFeedBackViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailShortActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityDetailShortBinding binding;
    private FeedBack feedBack;
    private GetFeedBackViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_short);
        initDataForViews();
        setOnClickForViews();
        initViewModel();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(GetFeedBackViewModel.class);
    }

    private void setOnClickForViews() {
        binding.tvConfirm.setOnClickListener(this);
        binding.tvCancel.setOnClickListener(this);
    }

    private void initDataForViews() {
        Intent intent = getIntent();
        binding.tvPersonSend.setText("Person send: " + intent.getIntExtra("KienDAB", 0));
        binding.tvContent.setText(intent.getStringExtra("KienDAA"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvConfirm:
                makeTheConfirm();
                break;
            case R.id.tvCancel:
                makeTheCancel();
                break;
        }
    }

    private void makeTheCancel() {
        finish();
    }

    private void makeTheConfirm() {
        viewModel.insertOrUpdateAReport(feedBack);
    }

}
