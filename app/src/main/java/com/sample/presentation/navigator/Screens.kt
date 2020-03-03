package com.sample.presentation.navigator

import com.sample.data.model.nasa.PhotoItem
import com.sample.data.model.user.User
import com.sample.presentation.ui.auth.signin.SignInFragment
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

    class SignInScreen : SupportAppScreen() {
        override fun getFragment() = SignInFragment.newInstance()
    }

    class NasaListScreen : SupportAppScreen() {
        override fun getFragment() = PhotoListFragment.newInstance()
    }



    class PhotoDetailsScreen(private val item: PhotoItem): SupportAppScreen(){
        override fun getFragment() = PhotoDetailsFragment.newInstance(item)
    }
}