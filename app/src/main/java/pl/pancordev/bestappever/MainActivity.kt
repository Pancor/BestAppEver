package pl.pancordev.bestappever

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import pl.pancordev.bestappever.locations.LocationsActivity
import pl.pancordev.bestappever.places.PlacesActivity

class MainActivity : AppCompatActivity() {

    init { main() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Glide
            .with(this)
            .load(R.drawable.ic_warning_black_24dp)
            .into(error_image)

        submit.setOnClickListener {
            startActivity(Intent(this, LocationsActivity::class.java))
        }

        places_button.setOnClickListener {
            startActivity(Intent(this, PlacesActivity::class.java))
        }
    }
}