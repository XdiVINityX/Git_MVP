
package com.example.gitlistmvp.mvp.di.modules

import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @Provides
    @Singleton
    fun router() : Router= cicerone.router

    @Provides
    @Singleton
    fun navigatorHolder() : NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    @Singleton
    fun screens() : IScreen = Screens()

}
