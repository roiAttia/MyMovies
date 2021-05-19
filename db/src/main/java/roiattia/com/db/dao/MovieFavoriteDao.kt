package roiattia.com.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import roiattia.com.db.model.MovieFavorite

@Dao
interface MovieFavoriteDao {

    @Query("SELECT * FROM movie_favorite")
    fun getMovies(): Flow<List<MovieFavorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movieFavorites: Collection<MovieFavorite>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieFavorite: MovieFavorite)

    @Query("DELETE FROM movie_favorite")
    suspend fun deleteAll()

}