package com.example.mypokemonapp.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CheckModelNull {

    @Test
    public void checkNullForUser() {
        User user = new User(null, null, null, null, null);
        assertNotNull(user.getUserId());
        assertNotNull(user.getUserEmail());
        assertNotNull(user.getUserName());
        assertNotNull(user.getUserPassword());
        assertNotNull(user.getUserPermission());
    }

    @Test
    public void checkNullPokemon() {
        Pokemon pokemon = new Pokemon(null, null, null, null, null, null, null, null, null, null, null, null, null);
        assertNotNull(pokemon.getId());
        assertNotNull(pokemon.getPokemonName());
        assertNotNull(pokemon.getPokemonUrl());
        assertNotNull(pokemon.getPokemonHeight());
        assertNotNull(pokemon.getPokemonWeight());
        assertNotNull(pokemon.getPokemonNextEvolutionA());
        assertNotNull(pokemon.getPokemonNextEvolutionB());
        assertNotNull(pokemon.getPokemonWeaknessA());
        assertNotNull(pokemon.getPokemonWeaknessB());
        assertNotNull(pokemon.getPokemonWeaknessC());
        assertNotNull(pokemon.getPokemonWeaknessD());
        assertNotNull(pokemon.getPokemonTypeA());
        assertNotNull(pokemon.getPokemonTypeB());
    }

    @Test
    public void checkNullUserPokemon() {
        UserPokemon userPokemon = new UserPokemon(1, "1", "2", "3");
        assertNotNull( userPokemon.getId());
        assertNotNull( userPokemon.getUserEmail());
        assertNotNull( userPokemon.getPokemonName());
        assertNotNull( userPokemon.getPokemonUrl());
    }
}
