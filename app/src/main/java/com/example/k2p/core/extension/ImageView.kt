package com.example.k2p.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.k2p.R

/**
 * Created by Amalip on 10/1/2021.
 */

@BindingAdapter("loadFromURLCircular")
fun ImageView.loadFromURLCircular(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_home)
    transformations(CircleCropTransformation())
}

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_home)
}