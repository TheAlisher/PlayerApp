package com.alis.player.ui.player

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {

    /*var isPauseOrPlay: MutableLiveData<Boolean> = MutableLiveData()

    private lateinit var mediaPlayer: MediaPlayer
    private var mIsPauseOrPlay: Boolean = true

    fun startPlayer(url: String?) {
        val url = url
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare()
            start()
        }
    }

    fun clickPausePlay() {
        if (mIsPauseOrPlay) {
            isPauseOrPlay.value = false
            mediaPlayer.stop()
        } else {
            isPauseOrPlay.value = true
            mediaPlayer.start()
        }
        mIsPauseOrPlay = !mIsPauseOrPlay
    }

    fun onBackPressed() {
        mediaPlayer.stop()
    }*/
}