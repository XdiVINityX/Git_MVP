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
    abstract val userReposDAO : UserReposDAO

    companion object{
        const val DB_NAME = "database.db"
        private var instance : Database? = null

        fun getInstance() = instance ?:  throw RuntimeException( "База данных не создана")

        fun create(context : Context?){
            if (instance == null){
                instance = Room.databaseBuilder(context!!,Database::class.java, DB_NAME).build()
            }
        }
        fun deleteDB(context : Context?){
            context?.let {
               val dbPath = it.getDatabasePath(DB_NAME)
                dbPath.delete()
                instance = null
            }
        }
    }
}