package pl.pancordev.bestappever.locations.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.locations.repository.LocationRepository
import pl.pancordev.bestappever.log

interface OnLocationsReady {

    fun setLocations(locations: List<LocationDescription>)
}

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()
    private val scope = CoroutineScope(Dispatchers.Main)

    fun getAllData(locationsReceiver: OnLocationsReady) {
        scope.launch {
            val locations = locationRepository.getLocationDescriptions()
            locationsReceiver.setLocations(locations)
        }
    }

    fun coroutinePlayground() {
        "run playground".log()

        scope.launch {
            "inside coroutine".log()
            val resultA = async(Dispatchers.IO) {
                val result = locationRepository.getCitiesFromServer()
                "cities: $result".log()
                42
            }
            val resultB = async(Dispatchers.IO) {
                "reading very big file B from disc".log()
                Thread.sleep(5000)
                "filre B ready".log()
                42
            }
            delay(5000)
            "after sleep".log()
            val modifyResult = resultA.await() + resultB.await()
            "RESULT = $modifyResult".log()
        }
    }
}