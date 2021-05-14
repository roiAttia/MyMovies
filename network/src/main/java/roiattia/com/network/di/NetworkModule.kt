package roiattia.com.network.di

import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import roiattia.com.network.ApiKeyInterceptor
import roiattia.com.network.TheMoviesDbService
import roiattia.com.network.NetworkConstants.BASE_URL
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    abstract fun provideInterceptor(apiKeyInterceptor: ApiKeyInterceptor): Interceptor

    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideOkHttpClient(keyInterceptor: Interceptor): OkHttpClient =
            OkHttpClient().newBuilder()
                .addInterceptor(keyInterceptor)
                .build()


        @JvmStatic
        @Singleton
        @Provides
        fun provideMoshiConverter(): MoshiConverterFactory = MoshiConverterFactory.create()

        @JvmStatic
        @Singleton
        @Provides
        fun provideMoshi(): Moshi = Moshi.Builder().build()

        @JvmStatic
        @Singleton
        @Provides
        fun provideRetrofit(
            converterFactory: MoshiConverterFactory,
            okHttpClient: OkHttpClient
        ): Retrofit.Builder =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)


        @JvmStatic
        @Singleton
        @Provides
        fun provideMoviesService(
            retrofitBuilder: Retrofit.Builder
        ): TheMoviesDbService = retrofitBuilder.build().create(TheMoviesDbService::class.java)

    }
}