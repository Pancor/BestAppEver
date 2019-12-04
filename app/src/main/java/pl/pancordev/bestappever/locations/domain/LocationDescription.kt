package pl.pancordev.bestappever.locations.domain

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

data class LocationDescription(val id: Int,
                               val name: String,
                               val imageUrl: String,
                               val address: String) {

    companion object {
        @BindingAdapter("locationImage")
        @JvmStatic
        fun loadImage(img: ImageView, imgUrl: String) {
            Glide
                .with(img.context)
                .load(imgUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(android.R.color.transparent)
                .centerCrop()
                .into(img)
        }
    }

}