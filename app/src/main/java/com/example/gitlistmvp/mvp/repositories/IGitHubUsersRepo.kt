package com.example.gitlistmvp.mvp.repositories

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGitHubUsersRepo {
    fun getUsers() : Single<List<GithubUser>>
    fun getUserRepos(login : String) : Single<List<UserRepos>>
}