package com.snazhmudinov.loop_demo.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snazhmudinov.loop_demo.R
import com.snazhmudinov.loop_demo.ViewHolders.ImageViewHolder

class ImageAdapter(context: Context, private val images: List<Int>, private val imageSelected: (Int, View) -> Unit)
    : RecyclerView.Adapter<ImageViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = layoutInflater.inflate(R.layout.image_view_holder, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(imageViewHolder: ImageViewHolder, position: Int) =
            with(imageViewHolder) {
                bindImage(images[position])
                imageClickListener = imageSelected
            }
}