package com.example.gitlistmvp.mvp.presentation.users

import com.example.gitlistmvp.mvp.model.GithubUser
import com.example.gitlistmvp.mvp.repositories.GithubUsersRepo
import com.example.gitlistmvp.mvp.presentation.users.adapter.UsersListPresenter
import com.example.gitlistmvp.mvp.presentation.navigation.Screens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UsersView>() {

     val usersListPresenter = UsersListPresenter(router, Screens())

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadDataObserverFromIterable()
        /*usersListPresenter.itemClickListener = {
            router.navigateTo(screens.user())
        }*/
    }


    private val repoObserver = object : Observer<GithubUser> {
        var disposable : Disposable? = null

        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onNext(t: GithubUser) {
            usersListPresenter.users.add(t)

        }

        override fun onError(e: Throwable) {
            //TODO("Not yet implemented")
        }
        override fun onComplete() {
            viewState.updateList()
        }
    }

   private fun loadDataObserverFromIterable(){
        usersRepo.getUsersObservableFromIterable().subscribe(repoObserver)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


}
