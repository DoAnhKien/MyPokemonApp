package com.example.mypokemonapp.ui.admin;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.callback.HandleUserPokemonClick;
import com.example.mypokemonapp.databinding.ItemFeedbackBinding;
import com.example.mypokemonapp.databinding.ItemReportBinding;
import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FeedBackAdapter extends RecyclerView.Adapter<FeedBackAdapter.ViewHolder> implements Filterable {

    private List<FeedBack> mFeedBack;
    private List<FeedBack> mFeedBackFull;


    public FeedBackAdapter(List<FeedBack> mFeedBack) {
        this.mFeedBack = mFeedBack;
        notifyDataSetChanged();
    }


    public void submitList(List<FeedBack> mFeedBack) {
        this.mFeedBack.clear();
        this.mFeedBack.addAll(mFeedBack);
        mFeedBackFull = mFeedBack;
        notifyDataSetChanged();
    }

    private HandleUserPokemonClick handleUserPokemonClick;

    public void deleteAUserPokemon(int position) {
        mFeedBack.remove(position);
        notifyDataSetChanged();
    }


    public void setHandleUserPokemonClick(HandleUserPokemonClick handleUserPokemonClick) {
        this.handleUserPokemonClick = handleUserPokemonClick;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemFeedbackBinding binding = ItemFeedbackBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull FeedBackAdapter.ViewHolder holder, int position) {
        holder.bind(mFeedBack.get(position));
    }

    private FeedBack getUserPokemonAt(int position) {
        return mFeedBack.get(position);
    }

    @Override
    public int getItemCount() {
        return mFeedBack.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFeedbackBinding binding;

        public ViewHolder(ItemFeedbackBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FeedBack feedBack) {
            binding.setFeedback(feedBack);
        }
    }

    @Override
    public Filter getFilter() {
        return userPokemonFilter;
    }


    private Filter userPokemonFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FeedBack> filteredList = new ArrayList<>();

            if (TextUtils.isEmpty(constraint)) {
                filteredList.addAll(mFeedBackFull);
            } else {
                String filterString = constraint.toString().toLowerCase();
                for (FeedBack currentFeedBack : mFeedBackFull) {
                    if (currentFeedBack.getUserId().toString().toLowerCase().contains(filterString)) {
                        filteredList.add(currentFeedBack);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFeedBack.clear();
            mFeedBack.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

