package roiattia.com.mymovies.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import roiattia.com.mymovies.di.module.ViewModelFactoryModule
import roiattia.com.mymovies.di.module.ViewModelsModule
import roiattia.com.network.di.NetworkModule

@Component(
    modules = [
        ViewModelFactoryModule::class,
        ViewModelsModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance applicationContext: Application): AppComponent
    }

}