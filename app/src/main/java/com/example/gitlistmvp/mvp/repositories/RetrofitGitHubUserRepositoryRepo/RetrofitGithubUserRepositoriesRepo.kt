package com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUserRepositoryRepo

import android.util.Log
import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.model.cache.cacheOfUserRepositories.ICacheGithubUserRepositories
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.network.retrofit.status.AndroidNetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUserRepositoriesRepo(
    private val api: IGitUsersApi,
    private val networkStatus: AndroidNetworkStatus,
    private val cache: ICacheGithubUserRepositories
) : IRetrofitGithubUserRepositoriesRepo {


    override fun getUserRepos(user: GithubUser): Single<List<UserRepos>> {
        return networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                    api.getUserRepos(user.login!!)
                        .flatMap { userReposList ->
                            Single.fromCallable {
                                cache.saveToCacheGithubUsers(user, userReposList)
                                userReposList
                            }
                        } ?: Single.error<List<UserRepos>>(RuntimeException("User has no repos url"))
                        .subscribeOn(Schedulers.io())

            }else {
                cache.getFromCacheUserRepos(user)
            }
        } .subscribeOn(Schedulers.io())
    }
}

