package pl.pancordev.bestappever.locations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_locations.*
import kotlinx.android.synthetic.main.activity_locations.toolbar
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.locations.domain.LocationDescription
import pl.pancordev.bestappever.locations.presentation.LocationDescriptionAdapter
import pl.pancordev.bestappever.locations.presentation.LocationViewModel
import pl.pancordev.bestappever.locations.presentation.OnLocationsReady

class LocationsActivity : AppCompatActivity(), OnLocationsReady {

    companion object {
        private const val DATA_KEY = "DATA_KEY"

        fun sendAdditionalText(context: Context, data: String): Intent {
            val intent = Intent(context, LocationsActivity::class.java)
            intent.putExtra(DATA_KEY, data)
            return intent
        }
    }

    private val locationAdapter = LocationDescriptionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)
        setSupportActionBar(toolbar)

        val locationViewModel = ViewModelProviders.of(this)[LocationViewModel::class.java]

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
