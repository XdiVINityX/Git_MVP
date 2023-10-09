package com.example.gitlistmvp.mvp.presentation.user.adapter

import com.example.gitlistmvp.mvp.presentation.users.adapter.IItemViewBase


interface IItemViewUserRepo : IItemViewBase {
    fun setNameOfRepo(nameOfRepo : String)
}