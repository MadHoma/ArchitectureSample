package com.sample.presentation.ui.users.list

import com.arellomobile.mvp.InjectViewState
import com.sample.data.model.user.User
import com.sample.data.network.UserService
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import timber.log.Timber

@InjectViewState
class UserListPresenter : BasePresenter<UserListView>() {

    private val mUserService: UserService by inject()
    private val mRouter: Router by inject()

    fun load() {
        addDisposable(mUserService.getMarsRoversPhotos(1, 50)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                viewState.addList(response.results)
            }, { e ->
                Timber.e(e)
                viewState.showMessage(e.localizedMessage)
            })
        )
    }

    fun openDetails(user: User) {
        mRouter.navigateTo(Screens.UserDetailsScreen(user))
    }

    fun openNasa(){
        mRouter.newRootScreen(Screens.NasaScreen())
    }
}