package com.example.mypokemonapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pokemonName")
    @Expose
    private String pokemonName;
    @SerializedName("pokemonUrl")
    @Expose
    private String pokemonUrl;

    public Pokemon() {
    }

    public Pokemon(Integer id, String pokemonName, String pokemonUrl) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.pokemonUrl = pokemonUrl;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}