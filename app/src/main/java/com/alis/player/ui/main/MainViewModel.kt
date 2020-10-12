package com.alis.player.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alis.player.models.Song
import com.alis.player.repository.SongRepository

class MainViewModel(private val songRepository: SongRepository) : ViewModel() {

    val cover: MutableLiveData<MutableList<Song>> = MutableLiveData()

    fun fetchSong(): MutableLiveData<MutableList<Song>> {
        return songRepository.fetchSong()
    }
}