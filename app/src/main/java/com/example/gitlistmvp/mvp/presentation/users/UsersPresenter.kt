package com.example.gitlistmvp.mvp.presentation.users

import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.example.gitlistmvp.mvp.presentation.users.adapter.UsersListPresenter
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.example.gitlistmvp.mvp.repositories.IGitHubUsersRepo
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresenter(
    private val retrofitGitHubUsersRepo: IGitHubUsersRepo,
    private val router: Router,
    private val mainThreadScheduler: Scheduler,
    private val screens: IScreen
) : MvpPresenter<UsersView>() {

     val usersListPresenter = UsersListPresenter(router, Screens())

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = {itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screens.user(user))
        }
    }

    private fun loadData() {
      val disposable = retrofitGitHubUsersRepo.getUsers()
            .observeOn(mainThreadScheduler)
            .subscribe({
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(it)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}
