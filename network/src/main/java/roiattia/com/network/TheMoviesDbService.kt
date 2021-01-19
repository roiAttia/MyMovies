package roiattia.com.network

import retrofit2.http.GET
import roiattia.com.network.data.response.MoviesListResponse

interface TheMoviesDbService {

    @GET(NetworkConstants.POPULAR_MOVIES_ENDPOINT)
    suspend fun getPopularMovies(): MoviesListResponse
}