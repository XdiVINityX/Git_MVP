package com.example.gitlistmvp.mvp.presentation.adapter

interface IListPresenter<V : IItemView> {
    fun openUserDetail(login : String)
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}
