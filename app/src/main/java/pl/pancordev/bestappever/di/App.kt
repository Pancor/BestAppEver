package pl.pancordev.bestappever.di

import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().app(this).build()
}