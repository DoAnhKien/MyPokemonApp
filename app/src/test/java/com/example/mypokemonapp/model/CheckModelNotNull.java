package com.example.mypokemonapp.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CheckModelNotNull {

    @Test
    public void checkNotNullForUser() {
        User user = new User(1, "1", "2", "3", "4");
        assertNotNull(user.getUserId());
        assertNotNull(user.getUserEmail());
        assertNotNull(user.getUserName());
        assertNotNull(user.getUserPassword());
        assertNotNull(user.getUserPermission());
    }

    @Test
    public void checkNotNullPokemon() {
        Pokemon pokemon = new Pokemon(1, "", "1", "2", "3", "4", "5", "6", "!7", "8", "9", "10", "11");
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
    public void checkNotNullUserPokemon() {
        UserPokemon userPokemon = new UserPokemon(1, "1", "2", "3");
        assertNotNull( userPokemon.getId());
        assertNotNull( userPokemon.getUserEmail());
        assertNotNull( userPokemon.getPokemonName());
        assertNotNull( userPokemon.getPokemonUrl());
    }

}
