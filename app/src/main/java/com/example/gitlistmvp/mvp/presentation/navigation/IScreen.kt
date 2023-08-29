package com.example.gitlistmvp.mvp.presentation.navigation

import com.example.gitlistmvp.mvp.presentation.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface IScreen {
    fun usersList() : FragmentScreen
    fun user(login : String) : FragmentScreen
}