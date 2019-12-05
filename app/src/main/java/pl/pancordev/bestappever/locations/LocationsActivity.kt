package pl.pancordev.bestappever.locations

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_locations.*
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.base.ViewModelProviderFactory
import pl.pancordev.bestappever.locations.domain.LocationsState
import pl.pancordev.bestappever.locations.presentation.LocationDescriptionAdapter
import javax.inject.Inject

class LocationsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var locationViewModel: LocationViewModel
    private val disposables = CompositeDisposable()

    private val locationAdapter = LocationDescriptionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_locations)
        setSupportActionBar(toolbar)
        swipe_to_refresh.isRefreshing = true

        locationViewModel = ViewModelProviders.of(this, factory)[LocationViewModel::class.java]

        val linearLayoutManager = LinearLayoutManager(this)

        recycler_view.layoutManager = linearLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = locationAdapter

        disposables.add(locationViewModel.dataStream()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { render(it) }
        )
    }

    private fun render(locationsState: LocationsState) {
        when (locationsState) {
            is LocationsState.LoadLocations -> { renderLocations(locationsState) }
            is LocationsState.UpdateLocations -> { updateLocations(locationsState) }
        }
    }

    private fun renderLocations(locationsState: LocationsState.LoadLocations) {
        swipe_to_refresh.isRefreshing = false
        locationAdapter.setLocations(locationsState.locations)
    }

    private fun updateLocations(locationsState: LocationsState.UpdateLocations) {
        swipe_to_refresh.isRefreshing = false
        locationAdapter.setLocations(locationsState.locations)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
