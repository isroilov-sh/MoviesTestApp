package com.example.moviestestapp

import android.app.Application
import com.example.moviestestapp.modules.NetworkModule
import com.example.moviestestapp.modules.VMModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        val networkModule = NetworkModule()
        val vmModules = VMModules()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule.getAPIRepositoryModule(),
                networkModule.getMediaServiceModule(),
                networkModule.getOKHttpClientModule(),
                vmModules.getMediaViewModel(),
            )
        }
    }
}