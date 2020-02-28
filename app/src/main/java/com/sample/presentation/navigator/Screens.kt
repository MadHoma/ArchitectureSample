package com.sample.presentation.navigator

import com.sample.data.model.user.User
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

//
//    class PhotoDetailsScreen(private val item: PhotoItem): SupportAppScreen(){
//        override fun getFragment() = PhotoDetailsFragment.newInstance(item)
//    }
//
//    class MainScreen: SupportAppScreen(){
//        override fun getActivityIntent(context: Context?): Intent {
//            return Intent(context, MainActivity::class.java)
//        }
//    }
}