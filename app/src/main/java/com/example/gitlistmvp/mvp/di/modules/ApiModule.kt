package com.example.gitlistmvp.mvp.di.modules

import android.content.Context
import com.example.gitlistmvp.mvp.App
import com.example.gitlistmvp.mvp.GIT_API_URL_BASE
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.network.retrofit.status.AndroidNetworkStatus
import com.example.gitlistmvp.mvp.network.retrofit.status.INetworkStatus
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = "https://api.github.com"

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Provides
    @Singleton
    fun api(@Named("baseUrl")baseUrl : String, gson : Gson) : IGitUsersApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IGitUsersApi::class.java)

    @Provides
    @Singleton
    fun networkStatus(app : App) : INetworkStatus = AndroidNetworkStatus(app)
}



