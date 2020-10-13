package com.alis.player.ui.player

import androidx.lifecycle.MutableLiveData
import com.alis.player.base.BaseViewModel

class PlayerViewModel : BaseViewModel() {

    var isPauseOrPlay: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isPauseOrPlay.value = true
    }
}