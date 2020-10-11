package com.alis.player.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alis.player.models.Song
import com.alis.player.repository.SongRepository

class MainViewModel(private val coverRepository: SongRepository) : ViewModel() {

    val cover: MutableLiveData<MutableList<Song>> = MutableLiveData()

    fun fetchCover(): MutableLiveData<MutableList<Song>> {
        return coverRepository.fetchCover()
    }
}