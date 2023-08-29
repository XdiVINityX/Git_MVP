package com.example.gitlistmvp.mvp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App  : Application() {
    companion object {
        lateinit var instanceApp : App
    }

    override fun onCreate() {
        super.onCreate()
        instanceApp = this
    }

    private val cicerone : Cicerone<Router> by lazy {Cicerone.create()}
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router


}