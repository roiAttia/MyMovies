package roiattia.com.mymovies.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import roiattia.com.mymovies.providers.MovieNetworkProvider
import roiattia.com.network.ResultWrapper
import roiattia.com.network.data.response.MovieResponse
import javax.inject.Inject

interface MovieRepository {

    val movies: LiveData<List<MovieResponse>>

    suspend fun getPopularMovies()
}

class MovieRepositoryImpl @Inject constructor(
    private val networkProvider: MovieNetworkProvider
) : MovieRepository {

    private val _movies = MutableLiveData<List<MovieResponse>>()
    override val movies: LiveData<List<MovieResponse>> = _movies

    override suspend fun getPopularMovies() {
        when (val response = networkProvider.getPopularMovies()) {
            is ResultWrapper.Success -> {
                _movies.value = response.value.results
            }
            is ResultWrapper.GeneralError -> TODO()
            is ResultWrapper.HttpError -> TODO()
            is ResultWrapper.NetworkConnectionError -> TODO()
        }
    }

}