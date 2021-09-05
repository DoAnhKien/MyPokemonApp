package com.example.mypokemonapp.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.callback.HandleUserPokemonClick;
import com.example.mypokemonapp.databinding.ItemUserPokemonBinding;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.UserPokemon;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UserPokemonAdapterA extends RecyclerView.Adapter<UserPokemonAdapterA.ViewHolder> implements Filterable {

    private List<UserPokemon> mUserPokemon;
    private List<UserPokemon> mUserPokemonFull;


    public UserPokemonAdapterA(List<UserPokemon> mUserPokemon) {
        this.mUserPokemon = mUserPokemon;
        notifyDataSetChanged();
    }


    public void submitList(List<UserPokemon> userPokemonList) {
        mUserPokemon.clear();
        mUserPokemon.addAll(userPokemonList);
        mUserPokemonFull = userPokemonList;
        notifyDataSetChanged();
    }

    private HandleUserPokemonClick handleUserPokemonClick;

    public void deleteAUserPokemon(int position) {
        mUserPokemon.remove(position);
        notifyDataSetChanged();
    }


    public void setHandleUserPokemonClick(HandleUserPokemonClick handleUserPokemonClick) {
        this.handleUserPokemonClick = handleUserPokemonClick;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemUserPokemonBinding binding = ItemUserPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserPokemonAdapterA.ViewHolder holder, int position) {
        holder.bind(mUserPokemon.get(position));
        holder.itemView.setOnLongClickListener(v -> {
            handleUserPokemonClick.onLongClick(getUserPokemonAt(position), position);
            return true;
        });
        holder.itemView.setOnClickListener(v -> handleUserPokemonClick.onClick(getUserPokemonAt(position), position));
    }

    private UserPokemon getUserPokemonAt(int position) {
        return mUserPokemon.get(position);
    }

    @Override
    public int getItemCount() {
        return mUserPokemon.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserPokemonBinding binding;

        public ViewHolder(ItemUserPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UserPokemon userPokemon) {
            binding.setUserPokemon(userPokemon);
        }
    }

    @Override
    public Filter getFilter() {
        return userPokemonFilter;
    }


    private Filter userPokemonFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<UserPokemon> filteredList = new ArrayList<>();

            if (TextUtils.isEmpty(constraint)) {
                filteredList.addAll(mUserPokemonFull);
            } else {
                String filterString = constraint.toString().toLowerCase();
                for (UserPokemon currentPokemon : mUserPokemonFull) {
                    if (currentPokemon.getPokemonName().toLowerCase().contains(filterString)) {
                        filteredList.add(currentPokemon);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mUserPokemon.clear();
            mUserPokemon.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
