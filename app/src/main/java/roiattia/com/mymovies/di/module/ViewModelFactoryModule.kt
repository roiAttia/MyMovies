package roiattia.com.mymovies.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import roiattia.com.mymovies.di.ViewModelProviderFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}