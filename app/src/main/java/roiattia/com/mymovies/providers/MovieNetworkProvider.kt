package roiattia.com.mymovies.providers

import roiattia.com.network.TheMoviesDbService
import roiattia.com.network.data.response.MoviesListResponse

interface MovieNetworkProvider {

    suspend fun getPopularMovies(): MoviesListResponse

}

class MoviesNetworkImpl(private val theMoviesDbService: TheMoviesDbService) : MovieNetworkProvider {

    override suspend fun getPopularMovies(): MoviesListResponse {
        return theMoviesDbService.getPopularMovies()
    }

}