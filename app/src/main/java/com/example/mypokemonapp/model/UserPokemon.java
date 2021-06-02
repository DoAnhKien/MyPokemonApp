package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserPokemon {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userEmail")
    @Expose
    private String userEmail;
    @SerializedName("pokemonName")
    @Expose
    private String pokemonName;
    @SerializedName("pokemonUrl")
    @Expose
    private String pokemonUrl;


    public UserPokemon() {
    }

    public UserPokemon(Integer id, String userEmail, String pokemonName, String pokemonUrl) {
        this.id = id;
        this.userEmail = userEmail;
        this.pokemonName = pokemonName;
        this.pokemonUrl = pokemonUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonUrl() {
        return pokemonUrl;
    }

    public void setPokemonUrl(String pokemonUrl) {
        this.pokemonUrl = pokemonUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPokemon that = (UserPokemon) o;
        return id.equals(that.id) &&
                userEmail.equals(that.userEmail) &&
                pokemonName.equals(that.pokemonName) &&
                pokemonUrl.equals(that.pokemonUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, pokemonName, pokemonUrl);
    }

    public boolean insertAUserPokemon(int id, String currentUserEmail, String currentPokemonName, String currentPokemonUrl) {
        User tempUserA = new User(1, "kienda", "1", "1", "1");
        User tempUserB = new User(2, "kienda", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        if (!currentUserEmail.equals("") && !currentPokemonName.equals("") && !currentPokemonUrl.equals("")) {
            for (int i = 0; i < mUsers.size(); i++) {
                if (!mUsers.get(i).getUserEmail().equals(currentUserEmail)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean findAUserPokemon(int userPokemonId) {
        UserPokemon tempUserPokemonA = new UserPokemon(1, "1", "1", "1");
        UserPokemon tempUserPokemonB = new UserPokemon(1, "1", "1", "1");
        List<UserPokemon> mUserPokemon = new ArrayList<>();
        mUserPokemon.add(tempUserPokemonA);
        mUserPokemon.add(tempUserPokemonB);
        for (int i = 0; i < mUserPokemon.size(); i++) {
            if (mUserPokemon.get(i).getId() == userPokemonId) {
                return true;
            }
        }
        return false;
    }

    public boolean updateAUserPokemon(UserPokemon userPokemon) {
        User tempUserA = new User(1, "kienda", "1", "1", "1");
        User tempUserB = new User(2, "kienda", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        for (int i = 0; i < mUsers.size(); i++) {
            if (mUsers.get(i).getUserEmail() == userPokemon.getUserEmail()) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteAUserPokemon(UserPokemon userPokemon) {
        User tempUserA = new User(1, "kienda", "1", "1", "1");
        User tempUserB = new User(2, "kienda", "2", "2", "2");
        List<User> mUsers = new ArrayList<>();
        mUsers.add(tempUserA);
        mUsers.add(tempUserB);
        for (int i = 0; i < mUsers.size(); i++) {
            if (mUsers.get(i).getUserEmail().equals(userPokemon.getUserEmail())) {
                return true;
            }
        }
        return false;
    }
}
