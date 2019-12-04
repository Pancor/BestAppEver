package pl.pancordev.bestappever.locations.repository

import com.google.gson.annotations.SerializedName

data class CityDto (
    @SerializedName("id") val id: Long,
    @SerializedName("url") val url: String,
    @SerializedName("city") val city: String,
    @SerializedName("description") val description: String
)