package roiattia.com.network.data.response

import com.squareup.moshi.Json

data class MovieResponse (

    @Json(name = "poster_path") val posterPath : String,
    @Json(name = "adult") val adult : Boolean,
    @Json(name = "overview") val overview : String,
    @Json(name = "release_date") val release_date : String,
    @Json(name = "genre_ids") val genre_ids : List<Int>,
    @Json(name = "id") val id : Int,
    @Json(name = "original_title") val originalTitle : String,
    @Json(name = "original_language") val original_language : String,
    @Json(name = "title") val title : String,
    @Json(name = "backdrop_path") val backdropPath : String,
    @Json(name = "popularity") val popularity : Double,
    @Json(name = "vote_count") val voteCount : Int,
    @Json(name = "video") val video : Boolean,
    @Json(name = "vote_average") val voteAverage : Double
)