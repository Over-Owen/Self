package com.overz.moviemvvm.data.vo


import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val budget: Int,
    val id: Int,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")      //告诉JSON这个和下面的两个是同一个东西，只是名字大小写
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val rating: Double

)