package com.sample.presentation.ui.nasa.details

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.sample.data.local.Constants.Arguments.PHOTO_ITEM
import com.sample.data.model.nasa.PhotoItem
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class PhotoDetailsPresenter : BasePresenter<PhotoDetailsView>() {


    private val mRouter: Router by inject()

    fun checkBundle(arg: Bundle?) {
        arg?.let { a ->
            if (a.containsKey(PHOTO_ITEM)) {
                viewState.setPhotoItem(a.getParcelable(PHOTO_ITEM) as PhotoItem)
            }
        }
    }

    fun openMain() {
    }

}