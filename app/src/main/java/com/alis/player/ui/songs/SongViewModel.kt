package com.alis.player.ui.songs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alis.player.models.Song
import com.alis.player.network.Resource
import com.alis.player.repository.SongRepository

class SongViewModel(private val songRepository: SongRepository) : ViewModel() {

    var song = MutableLiveData<Resource<MutableList<Song>>>()

    init {
        fetchSong()
    }

    private fun fetchSong() {
        song = songRepository.fetchSong() as MutableLiveData<Resource<MutableList<Song>>>
    }
}