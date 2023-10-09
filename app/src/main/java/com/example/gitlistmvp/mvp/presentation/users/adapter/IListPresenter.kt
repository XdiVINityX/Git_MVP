package com.example.gitlistmvp.mvp.presentation.users.adapter

interface IListPresenter<V : IItemViewBase> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
