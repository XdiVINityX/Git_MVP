package com.example.gitlistmvp.mvp

import android.app.Application
import com.example.gitlistmvp.mvp.di.AppComponent
import com.example.gitlistmvp.mvp.di.DaggerAppComponent
import com.example.gitlistmvp.mvp.di.modules.ApplicationModule
import com.example.gitlistmvp.mvp.model.room.Database
import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router


class App  : Application() {


    lateinit var appComponent : AppComponent

    companion object {
        lateinit var instanceApp : App
    }

    override fun onCreate() {
        super.onCreate()
        instanceApp = this

        appComponent = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}