package com.example.gitlistmvp.mvp.model.cache.cacheOfUserRepositories

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.model.room.Database
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUserRepository
import io.reactivex.rxjava3.core.Single

object CacheOfGithubUserRepositories : ICacheGithubUserRepositories {
    private val database: Database = Database.getInstance()


    override fun saveToCacheGithubUsers(user: GithubUser, userRepos: List<UserRepos>) {
        val roomUser = database.githubUsersDAO.findByLogin(user.login) ?: throw RuntimeException("No such user in cache")

        val userRepositories = userRepos.map { userRepos ->
            RoomGithubUserRepository(
                userRepos.id ?: "",
                userRepos.fullName ?: "",
                userRepos.forksCount ?: 0,
                roomUser.id
            )
        }
        database.userReposDAO.insert(userRepositories)
    }

    override fun getFromCacheUserRepos(user: GithubUser): Single<List<UserRepos>> {

        return Single.fromCallable {
            database.userReposDAO.findByUserId(user.id).map {
                UserRepos(id = it.userId, fullName = it.fullName, forksCount = it.forksCount)
            }
        }
    }


}