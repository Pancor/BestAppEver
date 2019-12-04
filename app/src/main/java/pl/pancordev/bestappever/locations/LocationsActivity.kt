package pl.pancordev.bestappever.locations

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_locations.*
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.base.ViewModelProviderFactory
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.locations.presentation.LocationDescriptionAdapter
import javax.inject.Inject

class LocationsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val locationAdapter = LocationDescriptionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_locations)
        setSupportActionBar(toolbar)

        swipe_to_refresh.isRefreshing = true

        val locationViewModel = ViewModelProviders.of(this, factory)[LocationViewModel::class.java]
        val linearLayoutManager = LinearLayoutManager(this)

        recycler_view.layoutManager = linearLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = locationAdapter

        val locationsObserver = Observer<List<LocationDescription>> {
            locationAdapter.setLocations(it)
            swipe_to_refresh.isRefreshing = false
        }
        locationViewModel.locationsLiveData.observe(this, locationsObserver)

        swipe_to_refresh.setOnRefreshListener {
            locationAdapter.setLocations(locationViewModel.locationsLiveData.value ?: emptyList())
            swipe_to_refresh.isRefreshing = false
        }
    }
}
