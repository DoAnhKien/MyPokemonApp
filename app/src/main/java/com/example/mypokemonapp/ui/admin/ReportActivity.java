package com.example.mypokemonapp.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.mypokemonapp.R;
import com.example.mypokemonapp.databinding.ActivityFeedBackBinding;
import com.example.mypokemonapp.databinding.ActivityReportBinding;
import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReportActivity extends AppCompatActivity implements OnReportItemClick {

    private String TAG = "KienDA";
    private ActivityReportBinding binding;
    private AdminViewModel viewModel;
    private ReportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_report);
        initViewModels();
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.mainSearch);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    private void initViewModels() {
        viewModel = new ViewModelProvider(this).get(AdminViewModel.class);
    }


    private void initViews() {
        List<Report> mReport = new ArrayList<>();
        adapter = new ReportAdapter(mReport, this);
        viewModel.requestAllReportsInServer();
        viewModel.getmReports().observe(this, reports -> {
            Log.d(TAG, "initViews: " + reports.size());
            adapter.submitList(reports);
        });
        binding.rvReport.setAdapter(adapter);
        binding.rvReport.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.rvReport.setHasFixedSize(true);
    }

    @Override
    public void onClick(Report report) {
        Intent intent = new Intent(this, DetailShortActivity.class);
        intent.putExtra("KienDAA", report.getReportContent());
        intent.putExtra("KienDAB", report.getUserId());
        startActivity(intent);
    }

    @Override
    public void onLongClick(Report report) {

    }

}