package com.example.gitlistmvp.mvp.network.retrofit.status


import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkStatus {

    fun isOnline() : Observable<Boolean>
    fun isOnlineSingle() : Single<Boolean>
}