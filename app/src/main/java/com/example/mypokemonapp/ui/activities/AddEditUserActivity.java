package com.example.mypokemonapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityAddEditUserBinding;
import com.example.mypokemonapp.databinding.ActivityAdminBinding;
import com.example.mypokemonapp.model.User;

public class AddEditUserActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityAddEditUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_user);
        initViews();
        setOnClickForViews();
    }

    private void setOnClickForViews() {
        binding.tvCancel.setOnClickListener(this);
        binding.tvConfirm.setOnClickListener(this);
    }

    private void initViews() {
        User user = (User) getIntent().getBundleExtra("mmm").getSerializable("123");
        binding.setUser(user);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCancel:
                checkForCancel();
                break;
            case R.id.tvConfirm:
                checkForConfirm();
                break;
        }
    }

    private void checkForConfirm() {

    }

    private void checkForCancel() {

    }
}