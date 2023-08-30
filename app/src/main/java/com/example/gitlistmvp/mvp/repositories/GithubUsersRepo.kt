package com.example.gitlistmvp.mvp.repositories

import com.example.gitlistmvp.mvp.model.GithubUser
import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )


    fun getUsersObservableFromIterable(): Observable<GithubUser> {
        return Observable.fromIterable(repositories)
    }



}
