package pl.pancordev.bestappever.locations.presentation

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.R

class LocationDescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image = itemView.findViewById<ImageView>(R.id.location_image)
    private val name = itemView.findViewById<TextView>(R.id.name_view)
    private val address = itemView.findViewById<TextView>(R.id.address_view)

    fun bindLocationDescription(location: LocationDescription) {
        name.text = location.name
        address.text = location.address
        Glide
            .with(itemView)
            .load(location.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(android.R.color.transparent)
            .centerCrop()
            .into(image)
    }
}