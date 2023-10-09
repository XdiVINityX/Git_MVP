package com.example.gitlistmvp.mvp.presentation.user

import android.util.Log
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.presentation.user.adapter.UserRepoListPresenter
import com.example.gitlistmvp.mvp.repositories.IGitHubUsersRepo
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UserPresenter(
    private val retrofit: IGitHubUsersRepo,
    private val mainThreadScheduler: Scheduler
) : MvpPresenter<IUserView>() {

    val userRepoListPresenter = UserRepoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

     fun loadData(login: String) {
        val disposable = retrofit.getUserRepos(login)
            .observeOn(mainThreadScheduler)
            .subscribe({
                Log.d("list", "loadData: $it")
                userRepoListPresenter.repoList.clear()
                userRepoListPresenter.repoList.addAll(it)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })

    }

}