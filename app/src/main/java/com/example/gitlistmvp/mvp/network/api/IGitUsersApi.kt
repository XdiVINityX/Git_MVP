package com.example.gitlistmvp.mvp.network.api


import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.GIT_API_END_POINT_USERS_URL
import com.example.gitlistmvp.mvp.GIT_API_END_REPOS
import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IGitUsersApi {

    @GET(GIT_API_END_POINT_USERS_URL)
    fun getUsers(): Single<List<GithubUser>>

    @GET("$GIT_API_END_POINT_USERS_URL/{username}/repos")
    fun getUserRepos(@Path("username") username : String) : Single<List<UserRepos>>

}