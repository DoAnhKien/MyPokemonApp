package com.example.mypokemonapp.ui.admin;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.callback.HandleUserPokemonClick;
import com.example.mypokemonapp.databinding.ItemReportBinding;
import com.example.mypokemonapp.model.Report;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> implements Filterable {

    private List<Report> mReports;
    private List<Report> mReportsFull;
    private OnReportItemClick onReportItemClick;


    public ReportAdapter(List<Report> mUserPokemon, OnReportItemClick onReportItemClick) {
        this.mReports = mUserPokemon;
        this.onReportItemClick = onReportItemClick;
        notifyDataSetChanged();
    }


    public void submitList(List<Report> mReports) {
        this.mReports.clear();
        this.mReports.addAll(mReports);
        mReportsFull = mReports;
        notifyDataSetChanged();
    }

    private HandleUserPokemonClick handleUserPokemonClick;

    public void deleteReportByPosition(int position) {
        mReports.remove(position);
        notifyDataSetChanged();
    }


    public void setHandleUserPokemonClick(HandleUserPokemonClick handleUserPokemonClick) {
        this.handleUserPokemonClick = handleUserPokemonClick;
    }

    @NonNull
    @NotNull
    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemReportBinding binding = ItemReportBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ReportAdapter.ViewHolder holder, int position) {
        holder.bind(mReports.get(position));
        holder.itemView.setOnClickListener(v -> onReportItemClick.onClick(mReports.get(position), position));
        holder.itemView.setOnLongClickListener(v -> {
            onReportItemClick.onLongClick(mReports.get(position), position);
            return true;
        });
    }

    private Report getReportAt(int position) {
        return mReports.get(position);
    }

    @Override
    public int getItemCount() {
        return mReports.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemReportBinding binding;

        public ViewHolder(ItemReportBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Report report) {
            binding.setReport(report);
        }
    }

    @Override
    public Filter getFilter() {
        return userPokemonFilter;
    }


    private Filter userPokemonFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Report> filteredList = new ArrayList<>();

            if (TextUtils.isEmpty(constraint)) {
                filteredList.addAll(mReportsFull);
            } else {
                String filterString = constraint.toString().toLowerCase();
                for (Report currentReport : mReportsFull) {
                    if (currentReport.getUserName().toString().toLowerCase().contains(filterString)) {
                        filteredList.add(currentReport);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mReports.clear();
            mReports.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

