package com.sample.presentation.ui.users.details

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.sample.data.local.Constants.Arguments.USER
import com.sample.data.model.user.User
import com.sample.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router

@InjectViewState
class UserDetailsPresenter : BasePresenter<UserDetailsView>() {

    private val mRouter: Router by inject()

    fun setArguments(arguments: Bundle?) {
        arguments?.getParcelable<User>(USER)?.let {
            viewState.showUser(it)
        }
    }

    fun onBack(){
        mRouter.exit()
    }
}