package com.example.gitlistmvp.mvp.model.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUser
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUserRepository
import java.lang.RuntimeException

@androidx.room.Database(entities = [RoomGithubUser::class,RoomGithubUserRepository::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract val githubUsersDAO : GithubUserDAO
    abstract val usersReposDAO : UserReposDAO

    companion object{
        private const val DB_NAME = "database.db"
        private var instance : Database? = null

        fun getInstance() = instance ?:  throw RuntimeException( "База данных не создана")

        fun create(context : Context?){
            if (instance ==null){
                instance = Room.databaseBuilder(context!!,Database::class.java, DB_NAME).build()
            }

        }
    }
}