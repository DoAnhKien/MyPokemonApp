package com.example.mypokemonapp.ui.admin;

import com.example.mypokemonapp.model.FeedBack;

public interface OnFeedBackItemClick {
    void onClick(FeedBack feedBack,int position);

    void onLongClick(FeedBack feedBack,int position);
}
