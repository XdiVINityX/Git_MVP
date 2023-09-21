package com.example.gitlistmvp.mvp.presentation.main


import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class MainPresenter(private val router: Router, private val screens : IScreen) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.usersList())
    }

    fun backClicked(){
        router.exit()
    }




}

