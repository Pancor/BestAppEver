package pl.pancordev.bestappever.locations

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.locations.repository.LocationRepository
import pl.pancordev.bestappever.log
import javax.inject.Inject

interface OnLocationsReady {

    fun setLocations(locations: List<LocationDescription>)
}

class LocationViewModel @Inject constructor(): ViewModel() {

    private val locationRepository = LocationRepository()

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)


    init {
        scope.launch {
            "started working".log()
            val locations = locationRepository.getLocationDescriptions()

            // TODO: zaktualizuj LiveData (MutableLiveData)
            //locationsReceiver.setLocations(locations)
            "finished".log()
        }

    }


    fun getAllData(locationsReceiver: OnLocationsReady) {
        scope.launch {
            "started working".log()
            val locations = locationRepository.getLocationDescriptions()
            locationsReceiver.setLocations(locations)
            "finished".log()
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

    override fun onCleared() {
        super.onCleared()
        job.cancelChildren()
    }
}