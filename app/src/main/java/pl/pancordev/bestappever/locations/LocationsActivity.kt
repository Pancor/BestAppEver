package pl.pancordev.bestappever.locations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_locations.*
import kotlinx.android.synthetic.main.activity_locations.toolbar
import pl.pancordev.bestappever.R
import pl.pancordev.bestappever.locations.presentation.LocationDescriptionAdapter
import pl.pancordev.bestappever.locations.repository.LocationRepository

class LocationsActivity : AppCompatActivity() {

    private val TAG = LocationsActivity::class.java.name

    companion object {
        private val DATA_KEY = "DATA_KEY"

        fun sendAdditionalText(context: Context, data: String): Intent {
            val intent = Intent(context, LocationsActivity::class.java)
            intent.putExtra(DATA_KEY, data)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)
        setSupportActionBar(toolbar)

        val linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()

        val locationsAdapter = LocationDescriptionAdapter()
        val locationRepository = LocationRepository()
        recycler_view.adapter = locationsAdapter

        locationsAdapter.setLocations(locationRepository.getLocationDescriptions())
    }
}
