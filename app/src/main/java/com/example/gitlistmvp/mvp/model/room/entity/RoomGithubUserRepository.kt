package com.example.gitlistmvp.mvp.model.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.gitlistmvp.mvp.model.room.entity.RoomGithubUser

@Entity (
    foreignKeys = [
        ForeignKey(
            entity = RoomGithubUser::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
//В данном случае, аннотация используется для обозначения @Entity сущности, которая связана с таблицей RoomGithubUser в базе данных.

data class RoomGithubUserRepository(
    @PrimaryKey var id: String,
    var fullName: String,
    var forksCount: Int,
    var userId: String
)

