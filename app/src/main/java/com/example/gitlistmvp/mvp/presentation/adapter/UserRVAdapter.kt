package com.example.gitlistmvp.mvp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonone.databinding.UserItemBinding

class UserRVAdapter(val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UserRVAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
                itemView.setOnClickListener{
                    presenter.itemClickListener?.invoke(this)
                }
            }
    }

    inner class MyViewHolder(val vb: UserItemBinding) : RecyclerView.ViewHolder(vb.root),
        IUserItemView {
        override var pos: Int = -1
        override fun setLogin(login: String) {
            vb.tvLogin.text = login
            itemView.setOnClickListener{
                presenter.openUserDetail(login)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            pos = position
        })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }
}




