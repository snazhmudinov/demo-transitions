package com.snazhmudinov.loop_demo.ViewHolders

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.image_view_holder.view.*

class ImageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var imageClickListener: ((Int, View) -> Unit)? = null

    fun bindImage(drawableRes: Int) {
        view.imageView.setImageDrawable(ContextCompat.getDrawable(view.context, drawableRes))
        view.setOnClickListener {
            imageClickListener?.invoke(drawableRes, it)
        }
    }
}