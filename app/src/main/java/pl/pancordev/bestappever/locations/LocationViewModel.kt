package pl.pancordev.bestappever.locations

import androidx.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import pl.pancordev.bestappever.locations.domain.LocationsState
import pl.pancordev.bestappever.locations.repository.LocationRepository
import javax.inject.Inject

class LocationViewModel @Inject constructor(): ViewModel() {

    private val locationRepository = LocationRepository()
    private val source = BehaviorSubject.create<LocationsState>()

    init {
        locationRepository.getLocationDescriptions()
            .subscribeOn(Schedulers.io())
            .subscribe { source.onNext(LocationsState.LoadLocations(it)) }
    }

    fun dataStream() = source
}