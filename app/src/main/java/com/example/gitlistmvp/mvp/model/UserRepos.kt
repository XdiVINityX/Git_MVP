package com.example.example

import com.google.gson.annotations.Expose


data class UserRepos (

@Expose var id                    : String?              = null,
@Expose var fullName              : String?           = null,
@Expose var forksCount           : Int?              = null,
)