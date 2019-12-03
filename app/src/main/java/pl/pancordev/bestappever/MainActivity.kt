package pl.pancordev.bestappever

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide
            .with(this)
            .load(R.drawable.ic_warning_black_24dp)
            .into(error_image)

        submit.setOnClickListener {
            error_description.text = find_location.text
            Toast.makeText(applicationContext, find_location.text, Toast.LENGTH_SHORT).show()
            val locationsActivityIntent = LocationsActivity.sendAdditionalText(this, find_location.text.toString())
            startActivity(locationsActivityIntent)
        }
    }
}