package roiattia.com.network.data.response

import com.squareup.moshi.Json

data class MoviesListResponse (

    @field:Json(name = "page") val page : Int,
    @field:Json(name = "results") val results : List<MovieResponse>,
    @field:Json(name = "total_results") val totalResults : Int,
    @field:Json(name = "total_pages") val totalPages : Int
)

data class MovieResponse (

    @field:Json(name = "poster_path") val posterPath : String,
    @field:Json(name = "adult") val adult : Boolean,
    @field:Json(name = "overview") val overview : String,
    @field:Json(name = "release_date") val release_date : String,
    @field:Json(name = "genre_ids") val genre_ids : List<Int>,
    @field:Json(name = "id") val id : Int,
    @field:Json(name = "original_title") val originalTitle : String,
    @field:Json(name = "original_language") val original_language : String,
    @field:Json(name = "title") val title : String,
    @field:Json(name = "backdrop_path") val backdropPath : String,
    @field:Json(name = "popularity") val popularity : Double,
    @field:Json(name = "vote_count") val voteCount : Int,
    @field:Json(name = "video") val video : Boolean,
    @field:Json(name = "vote_average") val voteAverage : Double
)