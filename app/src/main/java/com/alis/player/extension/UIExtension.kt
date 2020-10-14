package com.alis.player.extension

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(url: String? = null, placeholder: Int = 0) {
    Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}

fun ImageView.loadRoundImage(url: String? = null, placeholder: Int = 0, roundedRadius: Int = 0) {
    Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .transform(RoundedCorners(roundedRadius))
        .into(this)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}