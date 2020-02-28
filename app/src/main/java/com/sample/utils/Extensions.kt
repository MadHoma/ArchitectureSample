package com.sample.utils

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.setImageCircleFromUrl(url: String) {
    Glide.with(this).load(url).circleCrop().into(this)
}

fun ImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}

fun androidx.appcompat.widget.AppCompatImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}