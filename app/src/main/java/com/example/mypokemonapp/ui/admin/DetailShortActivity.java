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
import com.example.mypokemonapp.ui.getfeedback.GetFeedBackViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailShortActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityDetailShortBinding binding;
    private FeedBack feedBack = null;
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
        if (intent.getStringExtra("KienDAA") != null) {
            binding.tvPersonSend.setText("Person send: " + intent.getStringExtra("KienDAB"));
            binding.tvContent.setText(intent.getStringExtra("KienDAA"));
            return;
        }
        feedBack = (FeedBack) intent.getBundleExtra("kkk1").getSerializable("kkk");
        binding.tvPersonSend.setText("Person send: " + feedBack.getUserName());
        binding.tvContent.setText(feedBack.getFeedBackContent());
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
        if (feedBack != null) {
            feedBack.setHandle(true);
            viewModel.insertOrUpdateAFeedBack(feedBack);
            finish();
            return;
        }
        finish();
    }

}
