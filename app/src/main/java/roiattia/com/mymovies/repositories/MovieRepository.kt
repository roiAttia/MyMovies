package roiattia.com.mymovies.repositories

import roiattia.com.mymovies.providers.MovieNetworkProvider
import javax.inject.Inject

interface MovieRepository {
}

class MovieRepositoryImpl @Inject constructor(
    private val networkProvider: MovieNetworkProvider) : MovieRepository {

}