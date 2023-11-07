package com.example.gitlistmvp.mvp.repositories.RetrofitGithubUsersRepo

import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGitHubUsersRepo {
    fun getUsers() : Single<List<GithubUser>>
}