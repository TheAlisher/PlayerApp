package com.alis.player.ui.player

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {

    var isPauseOrPlay: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isPauseOrPlay.value = true
    }
}