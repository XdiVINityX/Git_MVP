package com.example.gitlistmvp.mvp.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomGithubUser(
    @PrimaryKey val id: Int,
    var login: String,
    var avatarUrl: String,
    var reposUrl: String
)
