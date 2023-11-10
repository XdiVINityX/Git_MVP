package com.example.gitlistmvp.mvp.presentation.users

import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.example.gitlistmvp.mvp.presentation.users.adapter.UsersListPresenter
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.example.gitlistmvp.mvp.repositories.RetrofitGithubUsersRepo.IGitHubUsersRepo
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter(private val mainThreadScheduler: Scheduler) : MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var retrofitGitHubUsersRepo: IGitHubUsersRepo
    @Inject
    lateinit var screens: IScreen

    lateinit var  usersListPresenter : UsersListPresenter

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        usersListPresenter = UsersListPresenter(router, screens)
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
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
