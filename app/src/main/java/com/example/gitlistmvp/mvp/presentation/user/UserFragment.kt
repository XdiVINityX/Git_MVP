package com.example.gitlistmvp.mvp.presentation.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitlistmvp.mvp.App
import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.model.room.Database
import com.example.gitlistmvp.mvp.network.retrofit.RetrofitClient
import com.example.gitlistmvp.mvp.network.status.AndroidNetworkStatus
import com.example.gitlistmvp.mvp.presentation.user.adapter.UserRVAdapter
import com.example.gitlistmvp.mvp.presentation.user.adapter.UserRepoListPresenter
import com.example.gitlistmvp.mvp.repositories.RetrofitGitHubUsersRepo
import com.example.lessonone.databinding.FragmentUserBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), IUserView{


    private var _binding : FragmentUserBinding? = null
    private val binding get() = _binding!!
    private var userRVAdapter : UserRVAdapter? = null

    private val presenter by  moxyPresenter {
        UserPresenter(RetrofitGitHubUsersRepo(RetrofitClient.api, AndroidNetworkStatus(App.instanceApp), Database.getInstance()), AndroidSchedulers.mainThread())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val user : GithubUser? = (it.getParcelable(USER)!!)
            setLogin(user?.login!!)
            Log.d("login", "onViewCreated: $user")
        }




    }
     override fun init(){
        userRVAdapter = UserRVAdapter(presenter.userRepoListPresenter)
        binding.recyclerViewUserRepo.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewUserRepo.adapter = userRVAdapter
    }

    override fun setLogin(login: String) {
        presenter.loadData(login)
    }

    override fun updateList() {
        userRVAdapter?.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(user : GithubUser) : UserFragment{
            val arg = Bundle()
            arg.putParcelable(USER,user)
            val fragment = UserFragment()
            fragment.arguments = arg
            return fragment
        }
        private const val USER = "USER"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}