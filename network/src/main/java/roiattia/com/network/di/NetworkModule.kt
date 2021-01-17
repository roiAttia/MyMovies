package roiattia.com.network.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import roiattia.com.network.NetworkConstants.BASE_URL
import javax.inject.Singleton

@Module
object NetworkModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMoshiConverter(): MoshiConverterFactory = MoshiConverterFactory.create()


    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofit(converterFactory: MoshiConverterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()

}