package com.example.mypokemonapp.callback;

import com.example.mypokemonapp.model.Pokemon;
import com.example.mypokemonapp.model.UserPokemon;

public interface HandleUserPokemonClick {
    void onClick(UserPokemon userPokemon, int position);

    void onLongClick(UserPokemon userPokemon, int position);
}
