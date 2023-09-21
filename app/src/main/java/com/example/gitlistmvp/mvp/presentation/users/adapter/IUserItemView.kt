package com.example.gitlistmvp.mvp.presentation.users.adapter

interface IUserItemView : IItemView {
    fun setLogin(login : String)
    fun setAvatar(url : String)
}