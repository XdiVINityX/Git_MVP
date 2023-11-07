package com.example.gitlistmvp.mvp.model.cache.cacheOfUsers

import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface ICacheGithubUsersDataBase {
    fun saveToCacheGithubUsers(githubUserList : List<GithubUser>)
    fun getFromCacheGithubUsers() : Single<List<GithubUser>>

}