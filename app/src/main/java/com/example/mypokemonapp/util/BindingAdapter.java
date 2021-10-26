package com.example.mypokemonapp.util;

import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mypokemonapp.adapter.PokemonAdapter;
import com.example.mypokemonapp.model.Pokemon;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("image_url")
    public static void setImageResource(ImageView imageView, String url) {
        Glide.with(imageView).load(url)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(imageView);
    }

    @androidx.databinding.BindingAdapter("image_resource")
    public static void setImageResource(ImageView imageView, int resource) {
        Glide.with(imageView).asBitmap()
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .load(resource).into(imageView);
    }

    @androidx.databinding.BindingAdapter("recyclerview:data")
    public static void setData(RecyclerView recyclerView, List<Pokemon> data) {
        if (recyclerView.getAdapter() instanceof PokemonAdapter) {
            ((PokemonAdapter) recyclerView.getAdapter()).setData(data);
        }
    }

    @androidx.databinding.BindingAdapter("recyclerview:adapter")
    public static void setAdapter(RecyclerView recyclerView, PokemonAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @androidx.databinding.BindingAdapter("convertDate")
    public static void convertDate(TextView textView, String time) {
        textView.setText(convertDate(time, "dd/MM/yyyy hh:mm:ss aa"));
    }

    @androidx.databinding.BindingAdapter("setUserNameForReportAndFeedBack")
    public static void setUserNameForReportAndFeedBack(TextView textView, String userName) {
        textView.setText("User name: " + userName);
    }


    @androidx.databinding.BindingAdapter("setUserEmailForReportAndFeedBack")
    public static void setUserEmailForReportAndFeedBack(TextView textView, String userName) {
        textView.setText("User gmail: " + userName);
    }

    public static String convertDate(String dateInMilliseconds, String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }
}
