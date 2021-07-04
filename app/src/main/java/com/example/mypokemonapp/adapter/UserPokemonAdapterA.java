package com.example.mypokemonapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.callback.HandleUserPokemonClick;
import com.example.mypokemonapp.databinding.ItemUserPokemonBinding;
import com.example.mypokemonapp.model.UserPokemon;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserPokemonAdapterA extends RecyclerView.Adapter<UserPokemonAdapterA.ViewHolder> {

    private List<UserPokemon> mUserPokemon;


    public UserPokemonAdapterA(List<UserPokemon> mUserPokemon) {
        this.mUserPokemon = mUserPokemon;
        notifyDataSetChanged();
    }


    public void submitList(List<UserPokemon> mUserPokemon) {
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
}
