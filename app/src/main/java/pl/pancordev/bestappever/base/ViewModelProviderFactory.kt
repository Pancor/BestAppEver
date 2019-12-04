package pl.pancordev.bestappever.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.pancordev.bestappever.locations.LocationViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LocationViewModel::class.java)) {
            LocationViewModel() as T
        } else {
            throw IllegalArgumentException("Unknown viewModel: ${modelClass.name}")
        }
    }
}