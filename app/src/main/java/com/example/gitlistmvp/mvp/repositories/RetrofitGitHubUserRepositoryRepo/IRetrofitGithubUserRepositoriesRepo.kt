package com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUserRepositoryRepo

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface IRetrofitGithubUserRepositoriesRepo {
    fun getUserRepos(user : GithubUser) : Single<List<UserRepos>>
}