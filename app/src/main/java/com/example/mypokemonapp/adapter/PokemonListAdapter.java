package com.example.mypokemonapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypokemonapp.callback.HandleClick;
import com.example.mypokemonapp.databinding.ItemPokemonBinding;
import com.example.mypokemonapp.model.Pokemon;


public class PokemonListAdapter extends ListAdapter<Pokemon, PokemonListAdapter.ViewHolder> {

    public PokemonListAdapter() {
        super(DIFF_CALLBACK);
    }
    private HandleClick handleClick;

    public void setHandleClick(HandleClick handleClick) {
        this.handleClick = handleClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonBinding binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setPokemon(getItem(position));
        holder.itemView.setOnClickListener(view -> handleClick.onClick(getCurrentList().get(position),position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPokemonBinding binding;

        public ViewHolder(ItemPokemonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.executePendingBindings();
        }
    }

    private static final DiffUtil.ItemCallback<Pokemon> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Pokemon>() {
                @Override
                public boolean areItemsTheSame(@NonNull Pokemon oldItem, @NonNull Pokemon newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Pokemon oldItem, @NonNull Pokemon newItem) {
                    return oldItem.equals(newItem);
                }
            };
}
