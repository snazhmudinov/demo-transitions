package com.snazhmudinov.loop_demo.Activities

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.snazhmudinov.loop_demo.R
import kotlinx.android.synthetic.main.activity_image_info.*

class ImageInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_info)

        val drawable = intent.getIntExtra(GalleryActivity.DRAWABLE_INTENT_EXTRA, R.drawable.image_1)
        imageView.setImageDrawable(ContextCompat.getDrawable(this, drawable))

        val animation = AnimationUtils.loadAnimation(this, R.anim.text_view_animation)
        textView.startAnimation(animation)
    }
}
