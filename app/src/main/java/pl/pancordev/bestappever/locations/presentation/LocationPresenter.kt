package pl.pancordev.bestappever.locations.presentation

import pl.pancordev.bestappever.locations.repository.LocationRepository

class LocationPresenter {

    private val locationRepository = LocationRepository()

    fun getAllData() = locationRepository.getLocationDescriptions()
}