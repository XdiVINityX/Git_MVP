package com.example.gitlistmvp.mvp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
  @Expose val login: String? = null,
  @Expose val id : Int? = null,
  @Expose val avatarUri:String? = null
    ) : Parcelable
