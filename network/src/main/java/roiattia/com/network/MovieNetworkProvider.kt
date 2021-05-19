package roiattia.com.network

import roiattia.com.network.model.response.MoviesListResponse
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