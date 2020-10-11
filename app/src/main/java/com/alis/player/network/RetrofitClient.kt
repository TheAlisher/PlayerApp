package com.alis.player.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL_COVER_API = "http://starlord.hackerearth.com/"

class RetrofitClient {

    internal val provideRetrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL_COVER_API)
        .build()

    fun provideCover() : SongAPI = provideRetrofit.create(SongAPI::class.java)
}