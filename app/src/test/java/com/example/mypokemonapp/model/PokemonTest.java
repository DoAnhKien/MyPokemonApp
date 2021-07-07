package com.example.mypokemonapp.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {

    @Test
    public void testTheInputDataOfThePokemonModel() {
        Pokemon pokemon = new Pokemon(1, "0", "1", "2", "3", "4", "5", "6", "!7", "8", "9", "10", "11");
        assertEquals(1, pokemon.getId());
        assertEquals("0", pokemon.getPokemonName());
        assertEquals("1", pokemon.getPokemonUrl());
        assertEquals("2", pokemon.getPokemonHeight());
        assertEquals("3", pokemon.getPokemonWeight());
        assertEquals("4", pokemon.getPokemonNextEvolutionA());
        assertEquals("5", pokemon.getPokemonNextEvolutionB());
        assertEquals("6", pokemon.getPokemonWeaknessA());
        assertEquals("!7", pokemon.getPokemonWeaknessB());
        assertEquals("8", pokemon.getPokemonWeaknessC());
        assertEquals("9", pokemon.getPokemonWeaknessD());
        assertEquals("10", pokemon.getPokemonTypeA());
        assertEquals("11", pokemon.getPokemonTypeB());
    }

    @Test
    public void testTheInputDataOfTheUserModel() {
        User user = new User(1, "1", "2", "3", "4");
        assertEquals(1, user.getUserId());
        assertEquals("1", user.getUserEmail());
        assertEquals("2", user.getUserName());
        assertEquals("3", user.getUserPassword());
        assertEquals("4", user.getUserPermission());
    }

    @Test
    public void testTheInputDataOfTheUserPokemon() {
        UserPokemon userPokemon = new UserPokemon(1, "1", "2", "3");
        assertEquals(1, userPokemon.getId());
        assertEquals("1", userPokemon.getUserEmail());
        assertEquals("2", userPokemon.getPokemonName());
        assertEquals("3", userPokemon.getPokemonUrl());
    }


    @Test
    public void testTheSetOutPutDataOfThePokemon() {
        Pokemon pokemon = new Pokemon(1, "000", "1111", "2222", "3333", "4444", "5555", "66666", "!77777", "888888", "99999", "10000", "1111111");
        pokemon.setId(1);
        pokemon.setPokemonName("0");
        pokemon.setPokemonUrl("1");
        pokemon.setPokemonHeight("2");
        pokemon.setPokemonWeight("3");
        pokemon.setPokemonNextEvolutionA("4");
        pokemon.setPokemonNextEvolutionB("5");
        pokemon.setPokemonWeaknessA("6");
        pokemon.setPokemonWeaknessB("!7");
        pokemon.setPokemonWeaknessC("8");
        pokemon.setPokemonWeaknessD("9");
        pokemon.setPokemonTypeA("10");
        pokemon.setPokemonTypeB("11");
        assertEquals(1, pokemon.getId());
        assertEquals("0", pokemon.getPokemonName());
        assertEquals("1", pokemon.getPokemonUrl());
        assertEquals("2", pokemon.getPokemonHeight());
        assertEquals("3", pokemon.getPokemonWeight());
        assertEquals("4", pokemon.getPokemonNextEvolutionA());
        assertEquals("5", pokemon.getPokemonNextEvolutionB());
        assertEquals("6", pokemon.getPokemonWeaknessA());
        assertEquals("!7", pokemon.getPokemonWeaknessB());
        assertEquals("8", pokemon.getPokemonWeaknessC());
        assertEquals("9", pokemon.getPokemonWeaknessD());
        assertEquals("10", pokemon.getPokemonTypeA());
        assertEquals("11", pokemon.getPokemonTypeB());
    }

    @Test
    public void testTheSetOutPutDataOfTheUser() {
        User user = new User(1, "aaa", "bbb", "ccc", "ddd");
        user.setUserId(3);
        user.setUserEmail("3");
        user.setUserName("3");
        user.setUserPassword("3");
        user.setUserPermission("3");
        assertEquals(3, user.getUserId());
        assertEquals("3", user.getUserEmail());
        assertEquals("3", user.getUserName());
        assertEquals("3", user.getUserPassword());
        assertEquals("3", user.getUserPermission());
    }

    @Test
    public void testTheSetOutPutDataOfTheUserPokemon() {
        UserPokemon userPokemon = new UserPokemon(1, "kien", "kien", "kkk");
        userPokemon.setId(2);
        userPokemon.setUserEmail("kien123");
        userPokemon.setPokemonName("kien123");
        userPokemon.setPokemonUrl("kien123");
        assertEquals(2, userPokemon.getId());
        assertEquals("kien123", userPokemon.getUserEmail());
        assertEquals("kien123", userPokemon.getPokemonName());
        assertEquals("kien123", userPokemon.getPokemonUrl());
    }


}