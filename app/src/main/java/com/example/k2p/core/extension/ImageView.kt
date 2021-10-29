package com.example.k2p.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.k2p.R


@BindingAdapter("loadFromURLCircular")
fun ImageView.loadFromURLCircular(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_home)
    transformations(CircleCropTransformation())
}

@BindingAdapter("loadFromURLRounded")
fun ImageView.loadFromURLRounded(url: String) = this.load(url){
    crossfade(true)
    placeholder(R.drawable.ic_random)
    transformations(RoundedCornersTransformation(30F))
}

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_home)
}