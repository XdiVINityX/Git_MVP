package com.example.gitlistmvp.mvp.model.cache.cacheOfUsers

import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.model.room.Database
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUser
import io.reactivex.rxjava3.core.Single

class CacheOfGithubUsers(private val database: Database) : ICacheGithubUsersDataBase {


    override fun saveToCacheGithubUsers(githubUserList : List<GithubUser>) {
        val newListOfRoomGithubUser = githubUserList.map { user ->
            RoomGithubUser(
                user.id.toString(),
                user.login ?: "",
                user.avatarUrl ?: "",
                user.reposUrl ?: ""
            )
        }
        database.githubUsersDAO.insert(newListOfRoomGithubUser)
    }

    override fun getFromCacheGithubUsers(): Single<List<GithubUser>> {
       return Single.fromCallable {
            database.githubUsersDAO.getAll().map { roomUser ->
                GithubUser(
                    roomUser.login,
                    roomUser.id,
                    roomUser.avatarUrl,
                    roomUser.reposUrl)
            }
        }
    }

}