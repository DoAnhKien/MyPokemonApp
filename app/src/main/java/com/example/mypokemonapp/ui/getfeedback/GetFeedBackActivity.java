package com.example.mypokemonapp.ui.getfeedback;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityGetFeedBackBinding;
import com.example.mypokemonapp.model.FeedBack;

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
        initDialogForFeedBack();
    }

    private void initDialogForFeedBack() {
        viewModel.getAllUserInLocalDatabase().observe(this, users -> {
                    viewModel.findAFeedBack(users.get(0).getUserId());
                    viewModel.getCurrentFeedBack().observe(this, feedback -> {
                        if (feedback != null) {
                            new AlertDialog.Builder(this)
                                    .setTitle("Last report have been confirm by admin")
                                    .setMessage(feedback.getFeedBackContent())
                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                                    .setNegativeButton(android.R.string.no, null)
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .show();
                        }
                    });
                }
        );

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
                    FeedBack feedBack = new FeedBack(0, users.get(0).getUserId(), String.valueOf(System.currentTimeMillis()), binding.edtContent.getText().toString(), false);
                    viewModel.insertOrUpdateAFeedBack(feedBack);
                    finish();
                }
        );

    }

    private void cancelActivity() {
        finish();
    }

}
