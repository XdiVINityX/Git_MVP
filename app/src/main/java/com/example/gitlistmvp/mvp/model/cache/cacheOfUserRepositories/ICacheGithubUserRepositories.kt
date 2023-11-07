package com.example.gitlistmvp.mvp.model.cache.cacheOfUserRepositories

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface ICacheGithubUserRepositories {
    fun getFromCacheUserRepos(user: GithubUser) : Single<List<UserRepos>>
    fun saveToCacheGithubUsers(user: GithubUser, userRepos : List<UserRepos>)
}