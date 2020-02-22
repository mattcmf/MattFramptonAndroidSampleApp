package com.matcmf.mattframpton_sampleapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun setImageResource(view: ImageView, imageUrl: String) {
    val context = view.context
    val options = RequestOptions()
        .placeholder(android.R.drawable.gallery_thumb)
        .error(android.R.drawable.stat_notify_error)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(imageUrl)
        .into(view)
}