package roiattia.com.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import roiattia.com.db.Constants.Companion.MOVIE_FAVORITE

@Entity(tableName = MOVIE_FAVORITE)
data class MovieFavorite(
    @PrimaryKey
    val id: Int,
    val title: String,
    val posterUrl: String?,
    val overview: String,
    val date: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int
)