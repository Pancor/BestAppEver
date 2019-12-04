package pl.pancordev.bestappever.locations.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.databinding.ItemLocationDescriptionBinding
import pl.pancordev.bestappever.log
import java.lang.IllegalArgumentException

class LocationDescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val cardView = itemView.findViewById<CardView>(R.id.card_view)

    fun bindLocationDescription(location: LocationDescription) {
        val binding = DataBindingUtil.findBinding(itemView) ?: DataBindingUtil.bind<ItemLocationDescriptionBinding>(itemView)
        binding?.locationDescription = location
        binding?.executePendingBindings()
        cardView.setOnClickListener {
            Toast.makeText(itemView.context, location.name, Toast.LENGTH_SHORT).show()
        }
    }
}