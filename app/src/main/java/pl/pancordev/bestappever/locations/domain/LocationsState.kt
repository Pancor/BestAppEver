package pl.pancordev.bestappever.locations.domain


sealed class LocationsState {

    data class LoadLocations(val locations: Array<LocationDescription>) : LocationsState()

    data class UpdateLocations(val locations: Array<LocationDescription>) : LocationsState()
}