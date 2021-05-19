package roiattia.com.db

import androidx.room.Database
import androidx.room.RoomDatabase
import roiattia.com.db.Constants.Companion.DB_VERSION
import roiattia.com.db.dao.MovieFavoriteDao
import roiattia.com.db.model.MovieFavorite

@Database(entities = [MovieFavorite::class], version = DB_VERSION)
abstract class MyMoviesDb : RoomDatabase() {

    abstract fun movieFavoriteDao(): MovieFavoriteDao

}