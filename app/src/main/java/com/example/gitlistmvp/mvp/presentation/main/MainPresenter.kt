package com.example.gitlistmvp.mvp.presentation.main


import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject


class MainPresenter() : MvpPresenter<MainView>() {

    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreen

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.usersList())
    }

    fun backClicked() {
        router.exit()
    }


}

