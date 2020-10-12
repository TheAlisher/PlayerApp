package com.alis.player.di

import com.alis.player.network.RetrofitClient
import com.alis.player.repository.SongRepository
import com.alis.player.ui.player.PlayerViewModel
import com.alis.player.ui.songs.SongViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var songModule = module {

    single { RetrofitClient().provideSong() }

    factory { SongRepository(get()) }

    viewModel { SongViewModel(get()) }
    viewModel { PlayerViewModel() }
}