package com.example.gitlistmvp.mvp.di.modules

import androidx.room.Room
import com.example.gitlistmvp.mvp.App
import com.example.gitlistmvp.mvp.model.cache.cacheOfUserRepositories.CacheOfGithubUserRepositories
import com.example.gitlistmvp.mvp.model.cache.cacheOfUserRepositories.ICacheGithubUserRepositories
import com.example.gitlistmvp.mvp.model.cache.cacheOfUsers.CacheOfGithubUsers
import com.example.gitlistmvp.mvp.model.cache.cacheOfUsers.ICacheGithubUsersDataBase
import com.example.gitlistmvp.mvp.model.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun database(app : App) : Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME).build()

    @Provides
    @Singleton
    fun cacheUsersRepo(db: Database): ICacheGithubUsersDataBase = CacheOfGithubUsers(db)

    @Provides
    @Singleton
    fun cacheUserRepos(db: Database): ICacheGithubUserRepositories = CacheOfGithubUserRepositories(db)


}