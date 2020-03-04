package com.sample.presentation.navigator

import android.content.Context
import android.content.Intent
import com.sample.data.model.nasa.PhotoItem
import com.sample.data.model.user.User
import com.sample.presentation.ui.auth.AuthActivity
import com.sample.presentation.ui.auth.forgot.ForgotPasswordFragment
import com.sample.presentation.ui.auth.signin.SignInFragment
import com.sample.presentation.ui.auth.signup.SignUpFragment
import com.sample.presentation.ui.nasa.details.PhotoDetailsFragment
import com.sample.presentation.ui.nasa.list.PhotoListFragment
import com.sample.presentation.ui.users.details.UserDetailsFragment
import com.sample.presentation.ui.users.list.UserListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class UserListScreen : SupportAppScreen() {
        override fun getFragment() = UserListFragment.newInstance()
    }


    class UserDetailsScreen(private val user: User) : SupportAppScreen() {
        override fun getFragment() = UserDetailsFragment.newInstance(user)
    }

    class NasaListScreen : SupportAppScreen() {
        override fun getFragment() = PhotoListFragment.newInstance()
    }

    class PhotoDetailsScreen(private val item: PhotoItem): SupportAppScreen(){
        override fun getFragment() = PhotoDetailsFragment.newInstance(item)
    }

    class AuthScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?) = Intent(context, AuthActivity::class.java)
    }

    class SignInScreen : SupportAppScreen() {
        override fun getFragment() = SignInFragment.newInstance()
    }

    class SignUpScreen : SupportAppScreen() {
        override fun getFragment() = SignUpFragment.newInstance()
    }

    class ForgotScreen : SupportAppScreen() {
        override fun getFragment() = ForgotPasswordFragment.newInstance()
    }
}