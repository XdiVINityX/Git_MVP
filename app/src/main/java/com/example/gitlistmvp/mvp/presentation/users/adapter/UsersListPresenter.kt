package com.example.gitlistmvp.mvp.presentation.users.adapter

import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.example.gitlistmvp.mvp.presentation.user.adapter.IItemViewUserRepo
import com.github.terrakok.cicerone.Router

class UsersListPresenter(private val router: Router, private val screens: IScreen) :
    IUserListPresenter {
    val users = mutableListOf<GithubUser>()
    override var itemClickListener: ((IUserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: IUserItemView) {
        val user = users[view.pos]
        user.login?.let {
            view.setLogin(it)
        }
        user.avatarUrl?.let {
            view.setAvatar(it)
        }
    }


}
