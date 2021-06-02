package com.example.mypokemonapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogic {

    @Test
    void testTheInsertUser() {
        User user = new User();
        boolean isSuccess = user.insertAUser(10, "3", "3", "4", "4");
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheUpdateUser() {
        User user = new User();
        boolean isSuccess = user.updateAUser(new User(123, "123", "123", "123", "123"));
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheDeleteUser() {
        User user = new User();
        boolean isSuccess = user.deleteAUser(new User(111, "123", "123", "123", "123"));
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheFindTheUser() {
        User user = new User();
        boolean isSuccess = user.findAUser(3);
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheInsertUserPokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.insertAUserPokemon(1, "kienda1", "123", "123");
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheUpdateUserPokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.updateAUserPokemon(new UserPokemon(1, "kienda11", "kien", "kien"));
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheDeletePokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.deleteAUserPokemon(new UserPokemon(1, "kienda11", "kien", "kien"));
        assertEquals(false, isSuccess);
    }

    @Test
    void testTheFindTheUserPokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.findAUserPokemon(2);
        assertEquals(false, isSuccess);
    }
}
