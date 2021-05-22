package com.example.mypokemonapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mypokemonapp.adapter.PokemonListAdapter;
import com.example.mypokemonapp.callback.HandleClick;
import com.example.mypokemonapp.databinding.FragmentFavoriteBinding;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private static FavoriteFragment INSTANCE;

    public static FavoriteFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FavoriteFragment();
        }
        return INSTANCE;
    }

    private PokemonViewModel viewModel;
    private List<Pokemon> mFavorites;
    //    private PokemonAdapter adapter;
    private PokemonListAdapter adapter;
    private FragmentFavoriteBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        mFavorites = new ArrayList<>();
        adapter = new PokemonListAdapter();
        binding.rvFavorite.setAdapter(adapter);
        viewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        viewModel.getFavoritePokemonList().observe(getViewLifecycleOwner(), pokemons -> {
            adapter.submitList(pokemons);
        });
        viewModel.getFavoritePokemon();
        setUpItemTouchHelper();
        listenerTheEvent();
        return binding.getRoot();
    }

    private void listenerTheEvent() {
        adapter.setHandleClick(new HandleClick() {
            @Override
            public void onClick(Pokemon pokemon, int position) {
                Toast.makeText(getActivity(), pokemon.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START | ItemTouchHelper.END) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                Pokemon pokemon = adapter.getCurrentList().get(swipedPokemonPosition);
                viewModel.deletePokemon(pokemon.getName());
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvFavorite);
    }
}
