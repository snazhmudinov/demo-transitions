package com.snazhmudinov.loop_demo.Activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.snazhmudinov.loop_demo.Adapters.ImageAdapter
import com.snazhmudinov.loop_demo.R
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    companion object {
        const val DRAWABLE_INTENT_EXTRA = "DRAWABLE_INTENT_EXTRA"
    }

    private lateinit var imagesAdapter: ImageAdapter

    // !!! For testing purposes only !!!
    private val images: List<Int> by lazy {
        listOf(
                R.drawable.image_1,
                R.drawable.image_2,
                R.drawable.image_3,
                R.drawable.image_4,
                R.drawable.image_5,
                R.drawable.image_6,
                R.drawable.image_7,
                R.drawable.image_8,
                R.drawable.image_9,
                R.drawable.image_10,
                R.drawable.image_11,
                R.drawable.image_12,
                R.drawable.image_13,
                R.drawable.image_14,
                R.drawable.image_15,
                R.drawable.image_16,
                R.drawable.image_17
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        imagesAdapter = ImageAdapter(this, images) { drawableRes, clickedView ->
            val intent = Intent(this, ImageInfoActivity::class.java).apply {
                putExtra(DRAWABLE_INTENT_EXTRA, drawableRes)
            }

            val options = ActivityOptions
                    .makeSceneTransitionAnimation(this, clickedView, "image")
            startActivity(intent, options.toBundle())
        }

        with(galleryRecyclerView) {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = imagesAdapter
        }
    }
}
