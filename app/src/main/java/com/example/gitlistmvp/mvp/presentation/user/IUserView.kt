package com.example.gitlistmvp.mvp.presentation.user

import com.example.gitlistmvp.mvp.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IUserView : MvpView {
    fun init()
    fun loadData(user : GithubUser)
    fun updateList()
}
