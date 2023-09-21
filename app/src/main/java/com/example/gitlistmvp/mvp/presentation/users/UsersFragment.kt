package com.example.gitlistmvp.mvp.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lessonone.databinding.FragmentUsersBinding
import com.example.gitlistmvp.mvp.App
import com.example.gitlistmvp.mvp.network.api.IGitUsersApi
import com.example.gitlistmvp.mvp.network.retrofit.RetrofitClient
import com.example.gitlistmvp.mvp.presentation.users.adapter.UserRVAdapter
import com.example.gitlistmvp.mvp.presentation.navigation.BackButtonListener
import com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(), UsersView,BackButtonListener {

    private var _binding : FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private var adapter : UserRVAdapter? = null

    private val presenter by moxyPresenter{
        UsersPresenter(RetrofitGitHubUsersRepo(RetrofitClient.ipi), App.instanceApp.router, AndroidSchedulers.mainThread(), App.instanceApp.screens)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater,container,false)
        return binding.root
    }


    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun init() {
        adapter = UserRVAdapter(presenter.usersListPresenter)
        binding.recyclerViewUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewUser.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed() = presenter.backPressed()


}