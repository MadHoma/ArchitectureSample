package com.sample.presentation.ui.auth.signup

import com.arellomobile.mvp.InjectViewState
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class SignUpPresenter : BasePresenter<SignUpView>() {
    private val mRouter: Router by inject()
    fun onBack() {
        mRouter.exit()
    }

    fun openSignIn() {
        mRouter.backTo(Screens.SignInScreen())
    }
}