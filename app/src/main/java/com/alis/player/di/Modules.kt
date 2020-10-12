package com.alis.player.di

import com.alis.player.network.RetrofitClient
import com.alis.player.repository.SongRepository
import com.alis.player.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var songModule = module {

    single { RetrofitClient().provideSong() }

    factory { SongRepository(get()) }

    viewModel { MainViewModel(get()) }
}