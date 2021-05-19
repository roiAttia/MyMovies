package roiattia.com.network.model.response

import com.squareup.moshi.Json

data class MoviesListResponse (

    @Json(name = "page") val page : Int,
    @Json(name = "results") val results : List<MovieResponse>,
    @Json(name = "total_results") val totalResults : Int,
    @Json(name = "total_pages") val totalPages : Int
)