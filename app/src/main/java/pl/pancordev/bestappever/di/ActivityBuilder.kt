package pl.pancordev.bestappever.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.pancordev.bestappever.locations.LocationsActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindLocationsActivity(): LocationsActivity
}