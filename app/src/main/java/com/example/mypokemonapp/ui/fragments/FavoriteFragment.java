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



import com.example.mypokemonapp.adapter.UserPokemonAdapterA;
import com.example.mypokemonapp.callback.HandleUserPokemonClick;
import com.example.mypokemonapp.databinding.FragmentFavoriteBinding;
import com.example.mypokemonapp.model.UserPokemon;
import com.example.mypokemonapp.ui.activities.LoginActivity;
import com.example.mypokemonapp.viewmodel.UserPokemonViewModel;


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
    public static UserPokemonAdapterA adapter;
    private FragmentFavoriteBinding binding;
    private List<UserPokemon> mUserPokemons;
    private String TAG = "kienda";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserPokemons = new ArrayList<>();
        adapter = new UserPokemonAdapterA(mUserPokemons);
        binding.rvFavorite.setAdapter(adapter);
        viewModel = new ViewModelProvider(getActivity()).get(UserPokemonViewModel.class);
        viewModel.getAllTheUserPokemonFromServer();
        viewModel.getmUserPokemon().observe(getViewLifecycleOwner(), userPokemons -> {
            LoginActivity.viewModel.getUserLogin().observe(getActivity(), user -> {

                List<UserPokemon> userPokemonList = new ArrayList<>();

                for (int i = 0; i < userPokemons.size(); i++) {
                    if (userPokemons.get(i).getUserEmail().equals(user.getUserEmail())) {
                        userPokemonList.add(userPokemons.get(i));
                    }
                }

                Log.d(TAG, "onViewCreated: " + userPokemonList.size());

                adapter.submitList(userPokemonList);

            });
        });


        listenerTheEvent();
    }

    private void listenerTheEvent() {
        adapter.setHandleUserPokemonClick(new HandleUserPokemonClick() {
            @Override
            public void onClick(UserPokemon userPokemon, int position) {

            }

            @Override
            public void onLongClick(UserPokemon userPokemon, int position) {
                Toast.makeText(getActivity(), "Đã xóa khỏi danh sách yêu thích", Toast.LENGTH_SHORT).show();
                adapter.deleteAUserPokemon(position);
                viewModel.deleteUserPokemon(userPokemon.getId());
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
                adapter.notifyItemRemoved(swipedPokemonPosition);

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.rvFavorite);
    }
}
