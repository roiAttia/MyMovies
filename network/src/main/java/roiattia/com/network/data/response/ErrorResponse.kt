package roiattia.com.network.data.response

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "status_message") val message : String,
    @field:Json(name = "status_code") val code : Int
)