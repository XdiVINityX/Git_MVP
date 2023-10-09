package com.example.gitlistmvp.mvp.presentation.users.adapter

interface IUserItemView : IItemViewBase {
    fun setLogin(login : String)
    fun setAvatar(url : String)
}