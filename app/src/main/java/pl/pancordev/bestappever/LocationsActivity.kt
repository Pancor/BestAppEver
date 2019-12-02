package pl.pancordev.bestappever

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_locations.*

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
        Log.e(TAG, "onCreate")

        start_third_activity.text = intent.getStringExtra(DATA_KEY)

        start_third_activity.setOnClickListener {
            val thirdActivityIntent = Intent(this, ThirdActivity::class.java)
            startActivity(thirdActivityIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }
}
