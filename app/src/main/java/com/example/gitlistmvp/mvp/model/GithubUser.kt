package com.example.gitlistmvp.mvp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    @Expose val login: String,
    @Expose val id: String,
    @Expose val avatarUrl: String? = null,
    @Expose val reposUrl: String? = null
) : Parcelable
