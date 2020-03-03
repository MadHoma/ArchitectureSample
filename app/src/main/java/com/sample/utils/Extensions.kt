package com.sample.utils

import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.R


fun ImageView.setImageCircleFromUrl(url: String) {
    Glide.with(this).load(url).circleCrop().placeholder(R.drawable.ic_mood).into(this)
}

fun ImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}

fun androidx.appcompat.widget.AppCompatImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}