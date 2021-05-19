package roiattia.com.network

import okhttp3.Interceptor
import okhttp3.Response
import roiattia.com.network.Constants.API_KEY

class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter(API_KEY, Constants.API_KEY_VALUE)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

}