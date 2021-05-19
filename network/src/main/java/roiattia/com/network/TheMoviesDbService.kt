package roiattia.com.network

import retrofit2.Response
import retrofit2.http.GET
import roiattia.com.network.model.response.MoviesListResponse

interface TheMoviesDbService {

    @GET(Constants.POPULAR_MOVIES_ENDPOINT)
    suspend fun  getPopularMovies(): Response<MoviesListResponse>
}