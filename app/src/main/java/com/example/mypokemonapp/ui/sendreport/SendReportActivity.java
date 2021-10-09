package com.example.mypokemonapp.ui.sendreport;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivitySendReportBinding;
import com.example.mypokemonapp.model.Report;
import com.example.mypokemonapp.ui.getfeedback.GetFeedBackViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SendReportActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySendReportBinding binding;
    private SendReportViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_report);
        setOnClickForViews();
        initViewModels();
    }

    private void setOnClickForViews() {
        binding.tvCancel.setOnClickListener(this);
        binding.tvConfirm.setOnClickListener(this);
    }

    private void initViewModels() {
        viewModel = new ViewModelProvider(this).get(SendReportViewModel.class);
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
                    Report report = new Report(0, 1, users.get(0).getUserId(), String.valueOf(System.currentTimeMillis()), "0", binding.edtContent.getText().toString(), "1123", true);
                    viewModel.insertOrUpdateAReport(report);
                    finish();
                }
        );

    }

    private void cancelActivity() {
        finish();
    }

}
