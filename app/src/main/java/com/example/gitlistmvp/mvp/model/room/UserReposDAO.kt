package com.example.gitlistmvp.mvp.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUserRepository

@Dao
interface UserReposDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGithubUserRepository)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomGithubUserRepository)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubUserRepository>)

    @Update
    fun update(user: RoomGithubUserRepository)
    @Update
    fun update(vararg users: RoomGithubUserRepository)
    @Update
    fun update(users: List<RoomGithubUserRepository>)

    @Delete
    fun delete(user: RoomGithubUserRepository)
    @Delete
    fun delete(vararg users: RoomGithubUserRepository)
    @Delete
    fun delete(users: List<RoomGithubUserRepository>)

    @Query("SELECT * FROM RoomGithubUserRepository")
    fun getAll() : List<RoomGithubUserRepository>

    @Query("SELECT * FROM RoomGithubUserRepository WHERE userId =:userId")
    fun findByUserId(userId : String) : List<RoomGithubUserRepository>
}