package com.alis.player.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<ViewModel : BaseViewModel>(
    private val layoutID: Int
) : AppCompatActivity() {

    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)

        initializeViews()
        setUpObservers()
        setUpListeners()
    }

    abstract fun initializeViews()

    abstract fun setUpObservers()

    abstract fun setUpListeners()
}