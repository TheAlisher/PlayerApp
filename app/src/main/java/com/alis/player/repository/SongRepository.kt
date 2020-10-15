package com.alis.player.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.alis.player.models.Song
import com.alis.player.network.Resource
import com.alis.player.network.SongAPI
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SongRepository(private val songAPI: SongAPI) {

    fun fetchSong() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = songAPI.fetchSong()))
        } catch (E: Exception) {
            emit(Resource.error(data = null, message = E.message ?: "Error Occured!"))
        }
    }


/*fun fetchSong(): MutableLiveData<MutableList<Song>> {
    val data: MutableLiveData<MutableList<Song>> = MutableLiveData()
    songAPI.fetchSong()
        .enqueue(object : Callback<MutableList<Song>> {
            override fun onResponse(
                call: Call<MutableList<Song>>,
                response: Response<MutableList<Song>>
            ) {
                Log.d("fetchCover", response.body().toString())
                data.value = response.body()
            }

            override fun onFailure(call: Call<MutableList<Song>>, t: Throwable) {
                Log.e("fetchCover", t.toString())
                data.value = null
            }
        })
    return data
}*/
}