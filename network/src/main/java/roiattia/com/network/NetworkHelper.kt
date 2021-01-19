package roiattia.com.network

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import roiattia.com.network.data.response.ErrorResponse
import java.io.IOException


object NetworkHelper {

    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> Response<T>
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                val callResponse = apiCall.invoke()
                if (callResponse.isSuccessful) {
                    ResultWrapper.Success(callResponse.body()!!)
                } else {
                    val errorResponse = convertErrorBody(callResponse.errorBody())
                    ResultWrapper.HttpError(errorResponse?.message, errorResponse?.code)
                }
            } catch (e: IOException) {
                ResultWrapper.NetworkConnectionError
            } catch (e: java.lang.Exception) {
                ResultWrapper.GeneralError
            }
        }
    }

    private fun convertErrorBody(errorBody: ResponseBody?): ErrorResponse? {
        if (errorBody != null) {
            return try {
                val moshi = Moshi.Builder().build()
                val jsonAdapter: JsonAdapter<ErrorResponse> = moshi.adapter(ErrorResponse::class.java)
                jsonAdapter.fromJson(errorBody.string())
            } catch (exception: Exception) {
                null
            }
        }
        return null
    }
}

sealed class ResultWrapper<out T> {

    data class Success<out T>(val value: T) : ResultWrapper<T>()

    data class HttpError(
        val message: String? = null,
        val code: Int? = null
    ) : ResultWrapper<Nothing>()

    object NetworkConnectionError : ResultWrapper<Nothing>()

    object GeneralError : ResultWrapper<Nothing>()
}