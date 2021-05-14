package roiattia.com.mymovies

import android.app.Application
import roiattia.com.mymovies.di.component.AppComponent

class MyMoviesApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        setAppComponent()
    }

    private fun setAppComponent() {
//        appComponent = DaggerAppComponent.factory().create(this)
    }
}