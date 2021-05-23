package com.example.mypokemonapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.databinding.ItemPokemonBinding;
import com.example.mypokemonapp.databinding.ItemUserBinding;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.User;

import org.jetbrains.annotations.NotNull;

public class UserAdapter extends ListAdapter<User, UserAdapter.ViewHolder> {

    public UserAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull UserAdapter.ViewHolder holder, int position) {
        holder.binding.setUser(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public ViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.executePendingBindings();
        }
    }

    private static final DiffUtil.ItemCallback<User> DIFF_CALLBACK = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull @NotNull User oldItem, @NonNull @NotNull User newItem) {
            return oldItem.getUserId() == newItem.getUserId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull User oldItem, @NonNull @NotNull User newItem) {
            return oldItem.equals(newItem);
        }
    };


}
