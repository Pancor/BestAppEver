package pl.pancordev.bestappever.locations.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.locations.domain.LocationDescription

class LocationDescriptionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var locations: List<LocationDescription> = emptyList()

    private val LOCATION_TYPE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_location_description, parent, false)
        return LocationDescriptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocationDescriptionViewHolder -> holder.bindLocationDescription(locations[position])
        }
    }

    override fun getItemCount() = locations.size

    override fun getItemViewType(position: Int): Int {
        return LOCATION_TYPE
    }

    fun setLocations(locations: List<LocationDescription>) {
        this.locations = locations
        notifyDataSetChanged()
    }
}