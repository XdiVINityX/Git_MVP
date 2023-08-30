package com.example.gitlistmvp.mvp.presentation.main

import android.os.Bundle
import com.example.lessonone.R
import com.example.lessonone.databinding.ActivityMainBinding
import com.example.gitlistmvp.mvp.App
import com.example.gitlistmvp.mvp.repositories.GithubUsersRepo
import com.example.gitlistmvp.mvp.presentation.users.adapter.UserRVAdapter
import com.example.gitlistmvp.mvp.presentation.navigation.BackButtonListener
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter


class MainActivity : MvpAppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        MainPresenter(App.instanceApp.router,Screens())
    }

    private val navigationHolder = App.instanceApp.navigatorHolder
    private val navigator = AppNavigator(this, R.id.container)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onBackPressed() {
        super.onBackPressed()


    }


}