package com.sample.presentation.ui.auth

import com.arellomobile.mvp.InjectViewState
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class AuthPresenter : BasePresenter<AuthView>() {

    private val mRoute: Router by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        mRoute.newRootScreen(Screens.SignInScreen())
    }

}