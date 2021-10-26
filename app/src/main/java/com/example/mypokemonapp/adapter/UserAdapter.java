package com.example.mypokemonapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.callback.OnItemUserOnClick;
import com.example.mypokemonapp.databinding.ItemUserBinding;
import com.example.mypokemonapp.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private OnItemUserOnClick onClick;
    private List<User> mUser = new ArrayList<>();


    public UserAdapter(OnItemUserOnClick onClick, List<User> mUser) {
        this.onClick = onClick;
        this.mUser = mUser;
    }


    public void submitNewData(List<User> mUser) {
        this.mUser.clear();
        this.mUser = mUser;
        notifyDataSetChanged();
    }

    public void updateCurrentUser(User user, int position) {
        mUser.set(position, user);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull UserAdapter.ViewHolder holder, int position) {
        holder.binding.setUser(mUser.get(position));
        holder.itemView.setOnClickListener(v -> {
            onClick.onClick(position, mUser.get(position));
        });
        holder.itemView.setOnLongClickListener(v -> {
            onClick.onLongClick(position, mUser.get(position));
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }


    public User getCurrentItem(int position) {
        return mUser.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public ViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.executePendingBindings();
        }
    }


}
