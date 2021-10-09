package com.example.mypokemonapp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.adapter.UserAdapter;
import com.example.mypokemonapp.databinding.ActivityFeedBackBinding;
import com.example.mypokemonapp.databinding.ActivityGetFeedBackBinding;
import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.ui.getfeedback.GetFeedBackViewModel;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FeedBackActivity extends AppCompatActivity implements OnFeedBackItemClick {

    private String TAG = "KienDA";
    private ActivityFeedBackBinding binding;
    private AdminViewModel viewModel;
    private FeedBackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_back);
        initViewModels();
        initViews();
    }

    private void initViewModels() {
        viewModel = new ViewModelProvider(this).get(AdminViewModel.class);
    }


    private void initViews() {
        List<FeedBack> mFeedBack = new ArrayList<>();
        adapter = new FeedBackAdapter(mFeedBack, this);
        viewModel.getmFeedBacks().observe(this, feedBacks -> {
            Log.d(TAG, "initViews: " + feedBacks.size());
            adapter.submitList(feedBacks);
        });
        viewModel.requestAllFeedBackInServer();
        binding.rvFeedBack.setAdapter(adapter);
        binding.rvFeedBack.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.rvFeedBack.setHasFixedSize(true);
    }

    @Override
    public void onClick(FeedBack feedBack) {
        Intent intent = new Intent(this, DetailShortActivity.class);
        intent.putExtra("KienDAA", feedBack.getFeedBackContent());
        intent.putExtra("KienDAB", feedBack.getUserId());
        startActivity(intent);
    }

    @Override
    public void onLongClick(FeedBack feedBack) {

    }
}