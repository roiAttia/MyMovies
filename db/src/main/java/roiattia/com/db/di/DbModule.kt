package roiattia.com.db.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import roiattia.com.db.Constants.Companion.DB_NAME
import roiattia.com.db.MyMoviesDb
import roiattia.com.db.dao.MovieFavoriteDao
import javax.inject.Singleton

@Module
object DbModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRoomDb(context: Context): MyMoviesDb =
        Room.databaseBuilder(context, MyMoviesDb::class.java, DB_NAME).build()

    @JvmStatic
    @Provides
    @Singleton
    fun getMovieFavoriteDao(db: MyMoviesDb): MovieFavoriteDao = db.movieFavoriteDao()

}