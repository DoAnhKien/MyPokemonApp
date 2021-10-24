package com.example.mypokemonapp.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.adapter.UserAdapter;

import com.example.mypokemonapp.callback.OnItemUserOnClick;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.model.User;
import com.example.mypokemonapp.ui.admin.FeedBackActivity;
import com.example.mypokemonapp.ui.admin.ReportActivity;
import com.example.mypokemonapp.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AdminActivity extends AppCompatActivity implements OnItemUserOnClick, View.OnClickListener {
    private static final int REQUEST_CODE = 123;
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
        setOnClickForView();
    }

    private void setOnClickForView() {
        binding.imgFeedBack.setOnClickListener(this);
        binding.imgReport.setOnClickListener(this);
        binding.tvSignOut.setOnClickListener(this);
    }

    private void initViews() {
        List<User> mUser = new ArrayList<>();
        adapter = new UserAdapter(this, mUser);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getAllUser().observe(this, users1 -> {
            adapter.submitNewData(users1);
        });
        viewModel.getAllUserOnServer();
        binding.rvAdmin.setAdapter(adapter);
        binding.rvAdmin.setHasFixedSize(true);
        viewModel.insertAUserForLocalDatabase(new User(1, "1", "1", "1", "1"));
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START | ItemTouchHelper.END) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                User user = adapter.getCurrentItem(swipedPokemonPosition);
                viewModel.deleteUserById(user.getUserId());
                adapter.notifyItemChanged(swipedPokemonPosition);
                viewModel.getAllUserOnServer();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvAdmin);
    }

    @Override
    public void onClick(int position, User user) {
        Intent intent = new Intent(this, AddEditUserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("123", user);
        intent.putExtra("mmm", bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onLongClick(int position, User user) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgFeedBack:
                moveToFeedBackActivity();
                break;
            case R.id.imgReport:
                moveToReportActivity();
                break;
            case R.id.tvSignOut:
                signOut();
                break;
        }
    }

    private void signOut() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void moveToReportActivity() {
        startActivity(new Intent(this, ReportActivity.class));
    }

    private void moveToFeedBackActivity() {
        startActivity(new Intent(this, FeedBackActivity.class));
    }


}