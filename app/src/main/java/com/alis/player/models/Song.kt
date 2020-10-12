package com.alis.player.models

import com.google.gson.annotations.SerializedName

data class Song(
    var song: String? = null,
    var url: String? = null,
    @SerializedName("artists")
    var artist: String? = null,
    @SerializedName("cover_image")
    var coverImage: String? = null
)
