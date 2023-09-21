package com.example.gitlistmvp.mvp.network.api


import com.example.gitlistmvp.mvp.GIT_API_END_POINT_USERS_URL
import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IGitUsersApi {

    @GET(GIT_API_END_POINT_USERS_URL)
    fun getUsers(): Single<List<GithubUser>>

}