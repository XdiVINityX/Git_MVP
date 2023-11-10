package com.example.gitlistmvp.mvp.presentation.user

import android.util.Log
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.presentation.user.adapter.UserRepoListPresenter
import com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUserRepositoryRepo.IRetrofitGithubUserRepositoriesRepo
import com.example.gitlistmvp.mvp.repositories.RetrofitGithubUsersRepo.IGitHubUsersRepo
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(
    private val mainThreadScheduler: Scheduler
) : MvpPresenter<IUserView>() {

    @Inject
    lateinit var retrofitGithubUserRepositoriesRepo: IRetrofitGithubUserRepositoriesRepo

    val userRepoListPresenter = UserRepoListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

     fun loadData(user : GithubUser) {
        val disposable = retrofitGithubUserRepositoriesRepo.getUserRepos(user)
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