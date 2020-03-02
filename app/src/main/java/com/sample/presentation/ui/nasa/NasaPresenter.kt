package com.sample.presentation.ui.nasa

import com.arellomobile.mvp.InjectViewState
import com.sample.presentation.base.BasePresenter
import com.sample.presentation.navigator.Screens
import ru.terrakok.cicerone.Router

@InjectViewState
class NasaPresenter : BasePresenter<NasaView>() {
    private val mRoute: Router by inject()

    fun showStartFragment() {
        mRoute.newRootScreen(Screens.NasaListScreen())
    }
}