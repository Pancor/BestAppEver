package pl.pancordev.bestappever.locations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_locations.*
import kotlinx.android.synthetic.main.activity_locations.toolbar
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.base.ViewModelProviderFactory
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.locations.presentation.LocationDescriptionAdapter
import javax.inject.Inject

class LocationsActivity : DaggerAppCompatActivity(), OnLocationsReady {

    companion object {
        private const val DATA_KEY = "DATA_KEY"

        fun sendAdditionalText(context: Context, data: String): Intent {
            val intent = Intent(context, LocationsActivity::class.java)
            intent.putExtra(DATA_KEY, data)
            return intent
        }
    }

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val locationAdapter = LocationDescriptionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_locations)
        setSupportActionBar(toolbar)

        val locationViewModel = ViewModelProviders.of(this, factory)[LocationViewModel::class.java]

        val linearLayoutManager = LinearLayoutManager(this)

        recycler_view.layoutManager = linearLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = locationAdapter

        locationViewModel.getAllData(this)
    }

    override fun setLocations(locations: List<LocationDescription>) {
        locationAdapter.setLocations(locations)
    }
}
