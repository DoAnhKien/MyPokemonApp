package com.example.mypokemonapp.ui.fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.example.mypokemonapp.adapter.PokemonListAdapter;
import com.example.mypokemonapp.adapter.UserPokemonAdapter;
import com.example.mypokemonapp.callback.HandleClick;
import com.example.mypokemonapp.databinding.FragmentFavoriteBinding;
import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.ui.activities.LoginActivity;
import com.example.mypokemonapp.viewmodel.UserPokemonViewModel;
import com.example.mypokemonapp.viewmodel.UserViewModel;


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

    private UserPokemonViewModel viewModel;

    private List<Pokemon> mFavorites;
    //    private PokemonAdapter adapter;
    private UserPokemonAdapter adapter;
    private FragmentFavoriteBinding binding;
    private List<UserPokemon> mUserPokemons = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        mFavorites = new ArrayList<>();
        adapter = new UserPokemonAdapter();
        binding.rvFavorite.setAdapter(adapter);
        viewModel = new ViewModelProvider(requireActivity()).get(UserPokemonViewModel.class);
        viewModel.getmUserPokemon().observe(getViewLifecycleOwner(), userPokemons -> {
            LoginActivity.viewModel.getUserLogin().observe(getActivity(), user -> {
                for (int i = 0; i < userPokemons.size(); i++) {
                    if (userPokemons.get(i).getUserEmail().equals(user.getUserEmail())) {
                        mUserPokemons.add(userPokemons.get(i));
                    }
                }
                adapter.submitList(mUserPokemons);
            });
        });

        viewModel.getAllTheUserPokemonFromServer();
        setUpItemTouchHelper();
        listenerTheEvent();
        return binding.getRoot();
    }

    private void listenerTheEvent() {

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
                UserPokemon userPokemon = adapter.getCurrentList().get(swipedPokemonPosition);
                viewModel.deleteUserPokemon(userPokemon.getId());
                adapter.notifyItemChanged(swipedPokemonPosition);
                viewModel.getAllTheUserPokemonFromServer();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvFavorite);
    }
}
