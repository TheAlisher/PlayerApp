package com.alis.player.network

import com.alis.player.models.Song
import retrofit2.Call
import retrofit2.http.GET

interface SongAPI {

    @GET("studio")
    fun fetchCover(): Call<MutableList<Song>>
}