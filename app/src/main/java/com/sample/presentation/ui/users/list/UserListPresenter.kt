package com.sample.presentation.ui.users.list

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.InjectViewState
import com.sample.data.model.user.User
import com.sample.data.network.UserService
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import com.sample.utils.PaginationScrollListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import timber.log.Timber

@InjectViewState
class UserListPresenter : BasePresenter<UserListView>() {

    private val mUserService: UserService by inject()
    private val mRouter: Router by inject()

    private var isLastPage = false
    private var isLoading = false
    private var page = 1

    fun load() {
        addDisposable(
            mUserService.getMarsRoversPhotos(page, 50)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                page++
                isLoading = false
                isLastPage = response.results.size < 50
                viewState.addList(response.results)
            }, { e ->
                isLoading = false
                Timber.e(e)
                viewState.showMessage(e.localizedMessage)
            })
        )
    }

    fun openDetails(user: User) {
        mRouter.navigateTo(Screens.UserDetailsScreen(user))
    }

    fun openNasa(){
        mRouter.newRootScreen(Screens.NasaListScreen())
    }

    fun openSignIn() {
        mRouter.navigateTo(Screens.AuthScreen())
    }

    fun load(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object :
            PaginationScrollListener(recyclerView.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                isLoading = true
                load()
            }
        })
        load()
    }

    fun refresh() {
        page = 1
        load()
    }
}