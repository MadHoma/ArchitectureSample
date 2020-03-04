package com.sample.presentation.ui.auth.forgot

import com.arellomobile.mvp.InjectViewState
import com.sample.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class ForgotPasswordPresenter : BasePresenter<ForgotPasswordView>() {
    private val mRouter: Router by inject()
    fun onBack() {
        mRouter.exit()
    }
}