package pl.pancordev.bestappever.locations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.locations.repository.LocationRepository
import pl.pancordev.bestappever.log
import javax.inject.Inject

class LocationViewModel @Inject constructor(): ViewModel() {

    private val locationRepository = LocationRepository()

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    val locationsLiveData: MutableLiveData<List<LocationDescription>> by lazy {
        MutableLiveData<List<LocationDescription>>()
    }

    init {
        scope.launch {
            val locations = locationRepository.getLocationDescriptions()
            locationsLiveData.value = locations
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancelChildren()
    }
}