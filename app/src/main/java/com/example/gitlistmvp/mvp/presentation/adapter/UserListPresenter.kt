package com.example.gitlistmvp.mvp.presentation.adapter

import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.presentation.navigation.IScreen
import com.github.terrakok.cicerone.Router

class UsersListPresenter(private val router: Router, private val screens: IScreen) : IUserListPresenter {
    val users = mutableListOf<GithubUser>()
    override var itemClickListener: ((IUserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: IUserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }

    override fun openUserDetail(login : String){
        router.navigateTo(screens.user(login))
    }
}
