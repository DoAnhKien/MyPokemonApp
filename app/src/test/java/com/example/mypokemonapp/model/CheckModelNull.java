package com.example.mypokemonapp.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CheckModelNull {

    @Test
    public void checkNullForUser() {
        User user = new User(null, null, null, null, null);
        assertNull(user.getUserId());
        assertNull(user.getUserEmail());
        assertNull(user.getUserName());
        assertNull(user.getUserPassword());
        assertNull(user.getUserPermission());
    }

    @Test
    public void checkNullPokemon() {
        Pokemon pokemon = new Pokemon(null, null, null, null, null, null, null, null, null, null, null, null, null);
        assertNull(pokemon.getId());
        assertNull(pokemon.getPokemonName());
        assertNull(pokemon.getPokemonUrl());
        assertNull(pokemon.getPokemonHeight());
        assertNull(pokemon.getPokemonWeight());
        assertNull(pokemon.getPokemonNextEvolutionA());
        assertNull(pokemon.getPokemonNextEvolutionB());
        assertNull(pokemon.getPokemonWeaknessA());
        assertNull(pokemon.getPokemonWeaknessB());
        assertNull(pokemon.getPokemonWeaknessC());
        assertNull(pokemon.getPokemonWeaknessD());
        assertNull(pokemon.getPokemonTypeA());
        assertNull(pokemon.getPokemonTypeB());
    }

    @Test
    public void checkNullUserPokemon() {
        UserPokemon userPokemon = new UserPokemon(1, "1", "2", "3");
        assertNull( userPokemon.getId());
        assertNull( userPokemon.getUserEmail());
        assertNull( userPokemon.getPokemonName());
        assertNull( userPokemon.getPokemonUrl());
    }
}
