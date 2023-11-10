package com.example.gitlistmvp.mvp.di

import com.example.gitlistmvp.mvp.di.modules.ApiModule
import com.example.gitlistmvp.mvp.di.modules.ApplicationModule
import com.example.gitlistmvp.mvp.di.modules.CiceroneModule
import com.example.gitlistmvp.mvp.di.modules.DatabaseModule
import com.example.gitlistmvp.mvp.di.modules.RepoModule
import com.example.gitlistmvp.mvp.presentation.main.MainActivity
import com.example.gitlistmvp.mvp.presentation.main.MainPresenter
import com.example.gitlistmvp.mvp.presentation.user.UserPresenter
import com.example.gitlistmvp.mvp.presentation.users.UsersFragment
import com.example.gitlistmvp.mvp.presentation.users.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        ApplicationModule::class,
        CiceroneModule::class,
        DatabaseModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
   fun inject(mainActivity: MainActivity)
   fun inject(usersFragment : UsersFragment)
   fun inject(mainPresenter: MainPresenter)

   fun inject(userPresenter: UserPresenter)
   fun inject(usersPresenter: UsersPresenter)

}