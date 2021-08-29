package com.example.mypokemonapp.adapter;

import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mypokemonapp.callback.HandleClick;
import com.example.mypokemonapp.databinding.ItemPokemonBinding;
import com.example.mypokemonapp.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> implements Filterable {

    private List<Pokemon> mPokemons;
    public PokemonAdapter(List<Pokemon> mPokemons) {
        this.mPokemons = mPokemons;
    }
    private HandleClick handleClick;

    public void setHandleClick(HandleClick handleClick) {
        this.handleClick = handleClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is binding data...
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setPokemon(getPokemonAt(position));
        holder.itemView.setOnClickListener(v -> {
            handleClick.onClick(getPokemonAt(position), position);
        });
    }

    public Pokemon getPokemonAt(int position) {
        return mPokemons.get(position);
    }

    @Override
    public int getItemCount() {
        return mPokemons == null ? 0 : mPokemons.size();
    }

    public void setData(List<Pokemon> data) {
        final PokeMonDiffCallback diffCallback = new PokeMonDiffCallback(this.mPokemons, data);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.mPokemons.clear();
        mPokemons.addAll(data);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemPokemonBinding binding;

        public ViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.executePendingBindings();
        }
    }

}
