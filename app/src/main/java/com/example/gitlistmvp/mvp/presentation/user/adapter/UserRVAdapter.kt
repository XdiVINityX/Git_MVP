package com.example.gitlistmvp.mvp.presentation.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonone.databinding.UserDetailItemBinding

class UserRVAdapter(private val presenter: UserRepoListPresenter) : RecyclerView.Adapter<UserRVAdapter.RepoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
       return RepoViewHolder(UserDetailItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        presenter.bindView(holder.apply {
            pos = position
        })
    }


    inner class RepoViewHolder(val vb : UserDetailItemBinding ) : RecyclerView.ViewHolder(vb.root), IItemViewUserRepo{
        override var pos: Int = -1
        override fun setNameOfRepo(nameOfRepo: String) {
            vb.repoNameTextView.text = nameOfRepo
        }

    }

    override fun getItemCount(): Int {
       return presenter.getCount()
    }

}