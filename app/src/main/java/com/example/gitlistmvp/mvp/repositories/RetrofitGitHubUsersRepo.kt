package com.example.gitlistmvp.mvp.repositories

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RetrofitGitHubUsersRepo(private val api : IGitUsersApi) : IGitHubUsersRepo  {
    override fun getUsers(): Single<List<GithubUser>> {
       return api.getUsers().subscribeOn(Schedulers.io())
    }

    override fun getUserRepos(login: String): Single<List<UserRepos>> {
        return api.getUserRepos(login).subscribeOn(Schedulers.io())
    }





}