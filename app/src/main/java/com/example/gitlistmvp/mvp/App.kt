package com.example.gitlistmvp.mvp

import android.app.Application
import com.example.gitlistmvp.mvp.model.room.Database
import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App  : Application() {
    companion object {
        lateinit var instanceApp : App
    }

    override fun onCreate() {
        super.onCreate()
        instanceApp = this
        Database.create(this)
    }

    private val cicerone : Cicerone<Router> by lazy {Cicerone.create()}
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router
    val screens : IScreen = Screens()


}