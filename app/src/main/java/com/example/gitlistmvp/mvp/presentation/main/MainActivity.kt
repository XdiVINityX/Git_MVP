package com.example.gitlistmvp.mvp.presentation.main

import android.os.Bundle
import com.example.lessonone.R
import com.example.lessonone.databinding.ActivityMainBinding
import com.example.gitlistmvp.mvp.App
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class MainActivity : MvpAppCompatActivity(), MainView {
    @Inject
    lateinit var navigationHolder : NavigatorHolder

    private val navigator = AppNavigator(this, R.id.container)

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instanceApp.appComponent.inject(this)
        }

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.instanceApp.appComponent.inject(this)
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