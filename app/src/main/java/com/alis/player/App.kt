package com.alis.player

import android.app.Application
import com.alis.player.di.songModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            this@App
            modules(songModule)
        }
    }
}