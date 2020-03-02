package com.sample.presentation.ui.nasa

import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.presentation.base.BaseActivity

class NasaActivity : BaseActivity(), NasaView {

    @InjectPresenter
    lateinit var mPresenter: NasaPresenter


    override fun getLayoutRes() = R.layout.activity_frame
    override fun getContainerRes(): Int = R.id.content_frame

    override fun initUI() {
        mPresenter.showStartFragment()
    }
}