package com.sample.presentation.navigator

import android.content.Context
import android.content.Intent
import com.sample.data.model.nasa.PhotoItem
import com.sample.data.model.user.User
import com.sample.presentation.ui.nasa.NasaActivity
import com.sample.presentation.ui.nasa.details.PhotoDetailsFragment
import com.sample.presentation.ui.nasa.list.PhotoListFragment
import com.sample.presentation.ui.users.MainActivity
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

    class UsersScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    class NasaListScreen : SupportAppScreen() {
        override fun getFragment() = PhotoListFragment.newInstance()
    }

    class NasaScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, NasaActivity::class.java)
        }
    }


    class PhotoDetailsScreen(private val item: PhotoItem): SupportAppScreen(){
        override fun getFragment() = PhotoDetailsFragment.newInstance(item)
    }
}