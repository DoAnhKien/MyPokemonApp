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


import org.jetbrains.annotations.NotNull;

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
    public UserViewModel parentModel;

    private List<Pokemon> mFavorites;
    //    private PokemonAdapter adapter;
    public static UserPokemonAdapter adapter;
    private FragmentFavoriteBinding binding;
    private List<UserPokemon> mUserPokemons = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFavorites = new ArrayList<>();
        setUpItemTouchHelper();
        adapter = new UserPokemonAdapter();
        binding.rvFavorite.setAdapter(adapter);
        viewModel = new ViewModelProvider(requireActivity()).get(UserPokemonViewModel.class);
        viewModel.getmUserPokemon().observe(getViewLifecycleOwner(), userPokemons -> {
            LoginActivity.viewModel.getUserLogin().observe(getActivity(), user -> {
                mUserPokemons.clear();
                for (int i = 0; i < userPokemons.size(); i++) {
                    if (userPokemons.get(i).getUserEmail().equals(user.getUserEmail())) {
                        mUserPokemons.add(userPokemons.get(i));
                    }
                }
                adapter.submitList(mUserPokemons);
            });
        });

        viewModel.getAllTheUserPokemonFromServer();
        listenerTheEvent();
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
                Log.d("mmm",mUserPokemons.size() + "");
                Log.d("mmm1",adapter.getCurrentList().size() + "");
                int swipedPokemonPosition = viewHolder.getAdapterPosition();
                UserPokemon userPokemon = adapter.getCurrentList().get(swipedPokemonPosition);
                viewModel.deleteUserPokemon(userPokemon.getId());
                adapter.notifyItemRemoved(swipedPokemonPosition);
                viewModel.getAllTheUserPokemonFromServer();
                Log.d("mmm",mUserPokemons.size() + "");
                Log.d("mmm1",adapter.getCurrentList().size() + "");
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvFavorite);
    }
}
