package com.example.mypokemonapp.ui.admin;

import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;

public interface OnReportItemClick {
    void onClick(Report report);

    void onLongClick(Report report);
}
