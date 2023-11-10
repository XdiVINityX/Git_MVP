package com.example.gitlistmvp.mvp.network.retrofit

import com.example.gitlistmvp.mvp.GIT_API_URL_BASE
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val api: IGitUsersApi by lazy {
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        Retrofit.Builder()
            .baseUrl(GIT_API_URL_BASE)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IGitUsersApi::class.java)
    }
}
