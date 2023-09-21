package com.example.gitlistmvp.mvp.presentation.navigation

import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.presentation.user.UserFragment
import com.example.gitlistmvp.mvp.presentation.users.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens : IScreen{
    override fun usersList(): FragmentScreen {
        return FragmentScreen{UsersFragment.newInstance()}
    }


    override fun user(user : GithubUser): FragmentScreen {
        return FragmentScreen{UserFragment.newInstance(user)}
    }

}