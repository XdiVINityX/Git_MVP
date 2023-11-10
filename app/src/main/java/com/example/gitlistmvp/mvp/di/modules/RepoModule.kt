package com.example.gitlistmvp.mvp.di.modules

import com.example.gitlistmvp.mvp.model.cache.cacheOfUserRepositories.ICacheGithubUserRepositories
import com.example.gitlistmvp.mvp.model.cache.cacheOfUsers.ICacheGithubUsersDataBase
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.network.retrofit.status.AndroidNetworkStatus
import com.example.gitlistmvp.mvp.network.retrofit.status.INetworkStatus
import com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUserRepositoryRepo.IRetrofitGithubUserRepositoriesRepo
import com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUserRepositoryRepo.RetrofitGithubUserRepositoriesRepo
import com.example.gitlistmvp.mvp.repositories.RetrofitGithubUsersRepo.IGitHubUsersRepo
import com.example.gitlistmvp.mvp.repositories.RetrofitGithubUsersRepo.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun githubUsersRepo(api: IGitUsersApi, networkStatus: INetworkStatus, cache: ICacheGithubUsersDataBase)
    : IGitHubUsersRepo =
        RetrofitGithubUsersRepo(api, networkStatus, cache)

    @Provides
    @Singleton
    fun githubUserRepo(api: IGitUsersApi, networkStatus: INetworkStatus, cache: ICacheGithubUserRepositories)
            : IRetrofitGithubUserRepositoriesRepo =
        RetrofitGithubUserRepositoriesRepo(api, networkStatus, cache)
}





