package com.example.mypokemonapp.ui.admin;

import com.example.mypokemonapp.model.FeedBack;
import com.example.mypokemonapp.model.Report;

public interface OnReportItemClick {
    void onClick(Report report,int position);

    void onLongClick(Report report,int position);
}
