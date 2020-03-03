package com.sample.presentation.ui.users

import com.arellomobile.mvp.InjectViewState
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    private val mRoute: Router by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        mRoute.newRootScreen(Screens.UserListScreen())
    }

    fun showStartFragment() {
        mRoute.newRootScreen(Screens.UserListScreen())
    }

}