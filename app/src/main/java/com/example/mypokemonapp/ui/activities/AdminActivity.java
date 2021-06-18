package com.example.mypokemonapp.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.adapter.UserAdapter;

import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AdminActivity extends AppCompatActivity {
    private ActivityAdminBinding binding;
    private UserViewModel viewModel;
    private UserAdapter adapter;
    private String TAG = "kienda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin);
        initViews();
        setUpItemTouchHelper();
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

    private void setUpItemTouchHelper() {
        Log.d(TAG, "setUpItemTouchHelper: kienda");
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START | ItemTouchHelper.END) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                User user = adapter.getCurrentList().get(swipedPokemonPosition);
                viewModel.deleteUserById(user.getUserId());
                adapter.notifyItemChanged(swipedPokemonPosition);
                viewModel.getAllUserOnServer();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvAdmin);
    }
}