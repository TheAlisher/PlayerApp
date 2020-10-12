package com.alis.player.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String?, placeholder: Int = 0) {
    Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}