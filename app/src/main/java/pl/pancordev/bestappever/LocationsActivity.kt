package pl.pancordev.bestappever

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_locations.*
import kotlinx.android.synthetic.main.activity_locations.toolbar

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

        start_third_activity.text = intent.getStringExtra(DATA_KEY)

        start_third_activity.setOnClickListener {
            val thirdActivityIntent = Intent(this, ThirdActivity::class.java)
            startActivity(thirdActivityIntent)
        }
    }
}
