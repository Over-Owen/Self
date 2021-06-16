package com.overz.moviemvvm.data.api

import com.overz.moviemvvm.data.vo.MovieDetails
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {
    //https://api.themoviedb.org/3/movie/popular?api_key=1888ca0b1a8fdfe3a25903dc93204575&page=1
    //https://api.themoviedb.org/3/movie/399566?api_key=1888ca0b1a8fdfe3a25903dc93204575            //
    //https://api.themoviedb.org/3/                                                                 //基础URL

    @GET("movie/{movie_id}")        //@ 导入retrofit依赖
    fun getMovieDetails(@Path("movie_id")id:Int): Single<MovieDetails> {            //Single<MovieDetails> 需要导入rxjava依赖
        return 0
    }
}