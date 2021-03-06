package com.sample.presentation.ui.auth.signin

import com.arellomobile.mvp.InjectViewState
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class SignInPresenter : BasePresenter<SignInView>() {
    private val mRouter: Router by inject()
    fun onBack() {
        mRouter.exit()
    }

    fun openSignUp() {
        mRouter.navigateTo(Screens.SignUpScreen())
    }

    fun openForgotPassword() {
        mRouter.navigateTo(Screens.ForgotScreen())
    }
}