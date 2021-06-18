package com.example.mypokemonapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.databinding.ItemUserPokemonBinding;
import com.example.mypokemonapp.model.UserPokemon;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserPokemonAdapter extends ListAdapter<UserPokemon, UserPokemonAdapter.ViewHolder> {

    public UserPokemonAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemUserPokemonBinding binding = ItemUserPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserPokemonAdapter.ViewHolder holder, int position) {
        holder.binding.setUserPokemon(getItem(position));
    }

    @Override
    public void onCurrentListChanged(@NonNull @org.jetbrains.annotations.NotNull List<UserPokemon> previousList, @NonNull @org.jetbrains.annotations.NotNull List<UserPokemon> currentList) {
        super.onCurrentListChanged(previousList, currentList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserPokemonBinding binding;

        public ViewHolder(ItemUserPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.executePendingBindings();
        }
    }

    private static final DiffUtil.ItemCallback<UserPokemon> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserPokemon>() {
        @Override
        public boolean areItemsTheSame(@NonNull @NotNull UserPokemon oldItem, @NonNull @NotNull UserPokemon newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull UserPokemon oldItem, @NonNull @NotNull UserPokemon newItem) {
            return oldItem.equals(newItem);
        }
    };

}
