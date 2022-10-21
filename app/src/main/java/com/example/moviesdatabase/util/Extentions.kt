package com.example.moviesdatabase.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(completeUrl: String) {

    Glide
        .with(this)

        .load(completeUrl)

        .into(this)


}