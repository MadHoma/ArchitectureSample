package com.sample.presentation.ui.nasa.list

import com.arellomobile.mvp.InjectViewState
import com.sample.data.model.nasa.PhotoItem
import com.sample.data.network.CommonService
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import timber.log.Timber


@InjectViewState
class PhotoListPresenter : BasePresenter<PhotoListView>() {

    private val mCommonService: CommonService by inject()
    private val mRouter: Router by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    fun loadData() {
        addDisposable(mCommonService.getMarsRoversPhotos("curiosity", 1000, "fhaz")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response?.let { r ->
                    r.photos?.let { viewState.addItems(it) }
                }
            }, { e ->
                Timber.e(e)
                viewState.showMessage(e.localizedMessage)
            })
        )

    }

    fun openDetailsScreen(item: PhotoItem) {
        mRouter.navigateTo(Screens.PhotoDetailsScreen(item))
    }

    fun openUsers() {

        mRouter.newRootScreen(Screens.UserListScreen())
    }

}