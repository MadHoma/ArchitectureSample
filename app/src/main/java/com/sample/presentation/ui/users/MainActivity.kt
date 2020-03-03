package com.sample.presentation.ui.users

import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.presentation.base.BaseActivity

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var mPresenter: MainPresenter


    override fun getLayoutRes() = R.layout.activity_frame
    override fun getContainerRes(): Int = R.id.content_frame

    override fun initUI() {}

}
