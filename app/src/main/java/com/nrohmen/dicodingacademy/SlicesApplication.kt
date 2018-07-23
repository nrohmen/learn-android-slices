package com.nrohmen.dicodingacademy

import android.app.Application
import com.nrohmen.dicodingacademy.state.AppState

class SlicesApplication : Application() {

    lateinit var appState: AppState

    override fun onCreate() {
        super.onCreate()
        appState = AppState()
    }
}