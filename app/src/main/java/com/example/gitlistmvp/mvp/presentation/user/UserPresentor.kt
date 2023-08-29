package com.example.gitlistmvp.mvp.presentation.user

import moxy.MvpPresenter

class UserPresenter(private val view : IUserView) : MvpPresenter<IUserView>() {

    fun setLogin(login : String){
        view.setLogin(login)
    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}