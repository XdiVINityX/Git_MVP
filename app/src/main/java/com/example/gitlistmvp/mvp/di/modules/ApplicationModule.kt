package com.example.gitlistmvp.mvp.di.modules

import com.example.gitlistmvp.mvp.App
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton

@Module
class ApplicationModule(val app: App) {

    @Provides
    fun app(): App = app

    @Provides
    fun mainThreadSchedulers()  : Scheduler =  AndroidSchedulers.mainThread()

}