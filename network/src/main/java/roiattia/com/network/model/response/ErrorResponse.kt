package roiattia.com.network.model.response

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "status_message") val message : String,
    @Json(name = "status_code") val code : Int
)