package com.example.mypokemonapp.callback;

import com.example.mypokemonapp.model.User;

public interface OnItemUserOnClick {
    void onClick(int position, User user);
    void onLongClick(int position, User user);
}
