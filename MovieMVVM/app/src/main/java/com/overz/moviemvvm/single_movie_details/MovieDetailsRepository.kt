package com.overz.moviemvvm.single_movie_details

import androidx.lifecycle.LiveData
import com.overz.moviemvvm.data.api.TheMovieDBInterface
import com.overz.moviemvvm.data.repository.MovieDetailsNetworkDataSource
import com.overz.moviemvvm.data.repository.NetworkState
import com.overz.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService: TheMovieDBInterface) {
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }
    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }
}