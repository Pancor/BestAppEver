package pl.pancordev.bestappever.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import pl.pancordev.bestappever.base.ViewModelProviderFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideViewModelProviderFactory(): ViewModelProviderFactory {
        return ViewModelProviderFactory()
    }
}