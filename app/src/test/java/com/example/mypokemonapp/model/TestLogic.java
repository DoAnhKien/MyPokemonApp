package com.example.mypokemonapp.model;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestLogic {

    @Test
    public void testTheInsertUser() {
        User user = new User();
        boolean isSuccess = user.insertAUser(3, "", "3", "4", "4");
        assertEquals(true, isSuccess);
    }

    @Test
    public void testTheUpdateUser() {
        User user = new User();
        boolean isSuccess = user.updateAUser(new User(123, "123", "123", "123", "123"));
        assertEquals(false, isSuccess);
    }

    @Test
    public void testTheDeleteUser() {
        User user = new User();
        boolean isSuccess = user.deleteAUser(new User(111, "123", "123", "123", "123"));
        assertEquals(false, isSuccess);
    }

    @Test
    public void testTheFindTheUser() {
        User user = new User();
        boolean isSuccess = user.findAUser(3);
        assertEquals(false, isSuccess);
    }

    @Test
    public void testTheInsertUserPokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.insertAUserPokemon(1, "kienda1", "123", "123");
        assertEquals(true, isSuccess);
    }

    @Test
    public void testTheUpdateUserPokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.updateAUserPokemon(new UserPokemon(1, "kienda11", "kien", "kien"));
        assertEquals(false, isSuccess);
    }

    @Test
    public void testTheDeleteUserPokemon() {
        UserPokemon userPokemon = new UserPokemon();
        boolean isSuccess = userPokemon.deleteAUserPokemon(new UserPokemon(1, "kienda11", "kien", "kien"));
        assertEquals(false, isSuccess);
    }

    @Test
    public void testTheFindTheUserPokemon() {
        UserPokemon user = new UserPokemon();
        boolean isSuccess = user.findAUserPokemon(2);
        assertEquals(false, isSuccess);
    }
}
