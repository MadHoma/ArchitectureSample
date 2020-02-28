package com.sample.presentation.ui.users.details

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.sample.data.local.Constants.Arguments.USER
import com.sample.data.model.user.User
import com.sample.presentation.base.BasePresenter

@InjectViewState
class UserDetailsPresenter : BasePresenter<UserDetailsView>() {
    fun setArguments(arguments: Bundle?) {
        arguments?.getParcelable<User>(USER)?.let {
            viewState.showUser(it)
        }
    }
}