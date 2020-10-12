package com.alis.player.ui.player

import android.app.Activity
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.alis.player.R
import com.alis.player.extension.loadImage
import com.alis.player.models.Song
import com.alis.player.utils.SimpleSeekBarChangeListener
import kotlinx.android.synthetic.main.activity_player.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerActivity : AppCompatActivity() {

    private val viewModel by viewModel<PlayerViewModel>()

    private lateinit var mediaPlayer: MediaPlayer
    private var handler = Handler()
    private var runnable: Runnable = object : Runnable {
        override fun run() {
            updateSeekBar()
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        this.setSongData()
        startPlayer()
        setUpListeners()
    }

    private fun setSongData() {
        image_player_song.loadImage(placeholder = R.drawable.default_image_album)
        text_player_name.text = item.song
        text_player_artist.text = item.artist
    }

    private fun startPlayer() {
        val url = item.url
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
            handler.postDelayed(runnable, 1000)
        }
    }

    private fun updateSeekBar() {
        if (mediaPlayer.isPlaying) {
            seek_player.progress =
                ((mediaPlayer.currentPosition.toFloat() / mediaPlayer.duration) * 100).toInt()
        }
    }

    private fun setUpListeners() {
        slideSeekPlayer()
        clickPrevious()
        clickPausePlay()
        clickNext()
    }

    private fun slideSeekPlayer() {
        seek_player.setOnSeekBarChangeListener(object : SimpleSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, p1: Int, p2: Boolean) {
                val playPosition: Int = (mediaPlayer.duration / 100) * seekBar.progress
                mediaPlayer.seekTo(playPosition)
            }
        })
    }

    private fun clickPrevious() {
        image_player_previous.setOnClickListener {

        }
    }

    private var isPause: Boolean = true

    private fun clickPausePlay() {
        image_player_pause_play.setOnClickListener {
            if (isPause) {
                mediaPlayer.pause()
                image_player_pause_play.setImageResource(R.drawable.icon_play)
            } else {
                mediaPlayer.start()
                image_player_pause_play.setImageResource(R.drawable.icon_pause)
            }
            isPause = !isPause
        }
    }

    private fun clickNext() {
        image_player_next.setOnClickListener {

        }
    }

    override fun onBackPressed() {
        mediaPlayer.stop()
        super.onBackPressed()
    }

    companion object {
        private lateinit var item: Song
        fun start(activity: Activity, item: Song) {
            this.item = item
            val intent = Intent(activity, PlayerActivity::class.java)
            activity.startActivity(intent)
        }
    }
}