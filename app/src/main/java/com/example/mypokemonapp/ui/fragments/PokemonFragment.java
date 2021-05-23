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


import com.example.mypokemonapp.adapter.PokemonAdapter;
import com.example.mypokemonapp.callback.HandleClick;
import com.example.mypokemonapp.databinding.FragmentPokemonBinding;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.viewmodel.UserPokemonViewModel;

import java.util.ArrayList;
import java.util.List;

public class PokemonFragment extends Fragment {

    private static PokemonFragment INSTANCE;
    private UserPokemonViewModel viewModel;
    private List<Pokemon> mPokemons;
    private PokemonAdapter adapter;
    private FragmentPokemonBinding binding;

    public static PokemonFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PokemonFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPokemonBinding.inflate(inflater, container, false);
        mPokemons = new ArrayList<>();
        adapter = new PokemonAdapter(mPokemons);
        viewModel = new ViewModelProvider(requireActivity()).get(UserPokemonViewModel.class);
        viewModel.getmPokemon().observe(getViewLifecycleOwner(), pokemons -> {
            adapter.setData(pokemons);
        });
        viewModel.getAllThePokemonFromServer();
        binding.rvPokemon.setAdapter(adapter);
        setUpItemTouchHelper();
        listenerEvent();
        return binding.getRoot();
    }

    private void listenerEvent() {
        adapter.setHandleClick(new HandleClick() {
            @Override
            public void onClick(Pokemon pokemon, int position) {
                Toast.makeText(getActivity(), pokemon.getPokemonName() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                Pokemon pokemon = adapter.getPokemonAt(swipedPokemonPosition);
                UserPokemon userPokemon = new UserPokemon(null, "kienda", pokemon.getPokemonName(), pokemon.getPokemonUrl());
                viewModel.insertOrUpdateUserPokemon(userPokemon);
                viewModel.getAllTheUserPokemonFromServer();
                adapter.notifyItemChanged(swipedPokemonPosition);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvPokemon);
    }
}
