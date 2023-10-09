package com.example.gitlistmvp.mvp.presentation.user.adapter

import com.example.example.UserRepos
import com.example.gitlistmvp.mvp.presentation.users.adapter.IUserItemView
import com.example.gitlistmvp.mvp.presentation.users.adapter.IUserListPresenter

class UserRepoListPresenter() : IListPresenterUserRepositories {

    val repoList = mutableListOf<UserRepos>()

    override var itemClickListener: ((IItemViewUserRepo) -> Unit)? = null

    override fun bindView(view: IItemViewUserRepo) {
       val repo = repoList[view.pos]
        repo.fullName?.let {
            view.setNameOfRepo(it)
        }
    }
    override fun getCount(): Int {
       return repoList.size
    }

}