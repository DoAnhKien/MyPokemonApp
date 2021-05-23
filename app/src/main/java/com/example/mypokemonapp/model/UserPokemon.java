package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
}
