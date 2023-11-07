package com.example.gitlistmvp.mvp.repositories.RetrofitGithubUsersRepo

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.model.cache.cacheOfUsers.ICacheGithubUsersDataBase
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.network.retrofit.status.AndroidNetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RetrofitGithubUsersRepo(
    private val api: IGitUsersApi,
    private val networkStatus: AndroidNetworkStatus,
    private val cache: ICacheGithubUsersDataBase
) : IGitHubUsersRepo {

    override fun getUsers(): Single<List<GithubUser>> {
        return networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                api.getUsers().flatMap { userList ->
                    Single.fromCallable {
                        cache.saveToCacheGithubUsers(userList)
                        userList
                    }
                }
            } else {
                cache.getFromCacheGithubUsers()
            }
        }.subscribeOn(Schedulers.io())
    }

}

