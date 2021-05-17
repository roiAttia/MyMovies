package roiattia.com.mymovies.providers

import roiattia.com.network.NetworkHelper
import roiattia.com.network.ResultWrapper
import roiattia.com.network.TheMoviesDbService
import roiattia.com.network.data.response.MoviesListResponse
import javax.inject.Inject

interface MovieNetworkProvider {

    suspend fun getPopularMovies(): ResultWrapper<MoviesListResponse>

}

class MoviesNetworkImpl @Inject constructor(
    private val theMoviesDbService: TheMoviesDbService
) : MovieNetworkProvider {

    override suspend fun getPopularMovies(): ResultWrapper<MoviesListResponse> {
        return NetworkHelper.safeApiCall {
            theMoviesDbService.getPopularMovies()
        }
    }

}