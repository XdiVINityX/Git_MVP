package com.example.gitlistmvp.mvp.repositories

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.model.room.Database
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUser
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.network.status.AndroidNetworkStatus
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class RetrofitGitHubUsersRepo(private val api : IGitUsersApi, private val networkStatus: AndroidNetworkStatus, private val dataBase: Database) : IGitHubUsersRepo  {
    override fun getUsers(): Single<List<GithubUser>> {
       return networkStatus.isOnlineSingle().flatMap { isOnline ->
           if (isOnline){
               api.getUsers().flatMap {userList ->
                   Single.fromCallable{
                       //В операциях на копию листа вешаем map и сохраняем в бд
                       val roomUsers = userList.map {user ->
                           RoomGithubUser(user.id ?: 0,user.login?: "",user.avatarUrl?: "",user.reposUrl?: "")
                       }
                       dataBase.githubUsersDAO.insert(roomUsers)
                       userList
                   }
               }
           }else{
             Single.fromCallable{
                   dataBase.githubUsersDAO.getAll().map { roomUser->
                       GithubUser(roomUser.login,roomUser.id,roomUser.avatarUrl,roomUser.reposUrl)
                   }
               }
           }
       }.subscribeOn(Schedulers.io())
    }


    override fun getUserRepos(login: String): Single<List<UserRepos>> {
        return api.getUserRepos(login).subscribeOn(Schedulers.io())
    }
}
