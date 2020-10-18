package com.alis.player.ui.player

import android.app.Activity
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Handler
import android.widget.SeekBar
import com.alis.player.R
import com.alis.player.base.BaseActivity
import com.alis.player.extension.gone
import com.alis.player.extension.loadImage
import com.alis.player.extension.visible
import com.alis.player.models.Song
import com.alis.player.utils.SimpleSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_player.*
import org.koin.android.ext.android.inject

class PlayerActivity : BaseActivity<PlayerViewModel>(R.layout.activity_player) {

    companion object {
        private lateinit var item: Song
        fun start(activity: Activity, item: Song) {
            this.item = item
            val intent = Intent(activity, PlayerActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        parseSong()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    override val viewModel by inject<PlayerViewModel>()

    private lateinit var mediaPlayer: MediaPlayer
    private var handler = Handler()
    private var runnable: Runnable = object : Runnable {
        override fun run() {
            updateSeekBar()
            handler.postDelayed(this, 1000)
        }
    }

    override fun initializeViews() {
        setSongData()
        createPlayer()
    }

    override fun setUpObservers() {

    }

    override fun setUpListeners() {
        slideSeekPlayer()
        clickPrevious()
        clickPausePlay()
        clickNext()
    }

    private fun setSongData() {
        image_player_song.loadImage(placeholder = R.drawable.default_image_album)
        text_player_name.text = item.song
        text_player_artist.text = item.artist
    }

    private fun createPlayer() {
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        }
    }

    private fun updateSeekBar() {
        if (mediaPlayer.isPlaying) {
            seek_player.progress = mediaPlayer.currentPosition / 1000
        }
    }

    private fun slideSeekPlayer() {
        seek_player.setOnSeekBarChangeListener(object : SimpleSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                mediaPlayer.seekTo(seekBar.progress * 1000)
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                }
            }
        })
    }

    private fun clickPrevious() {
        image_player_previous.setOnClickListener {

        }
    }

    private fun clickPausePlay() {
        image_player_pause_play.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                image_player_pause_play.setImageResource(R.drawable.icon_play)
            } else {
                mediaPlayer.start()
                image_player_pause_play.setImageResource(R.drawable.icon_pause)
            }
        }
    }

    private fun clickNext() {
        image_player_next.setOnClickListener {

        }
    }

    private fun parseSong() {
        mediaPlayer.apply {
            setDataSource(item.url)
            prepareAsync()
            progress_player.visible()
            setOnPreparedListener {
                progress_player.gone()
                start()
                seek_player.max = mediaPlayer.duration / 1000
                handler.postDelayed(runnable, 1000)
            }
        }
    }
}