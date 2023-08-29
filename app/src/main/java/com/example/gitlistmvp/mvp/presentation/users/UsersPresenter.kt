package com.example.gitlistmvp.mvp.presentation.users

import com.example.gitlistmvp.mvp.repositories.GithubUsersRepo
import com.example.gitlistmvp.mvp.presentation.adapter.UsersListPresenter
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UsersView>() {

     val usersListPresenter = UsersListPresenter(router, Screens())

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        /*usersListPresenter.itemClickListener = {
            router.navigateTo(screens.user())
        }*/
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}
