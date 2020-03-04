package com.sample.presentation.ui.auth

import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.presentation.base.BaseActivity

class AuthActivity : BaseActivity(), AuthView {

    @InjectPresenter
    lateinit var mPresenter: AuthPresenter


    override fun getLayoutRes() = R.layout.activity_frame
    override fun getContainerRes(): Int = R.id.content_frame

    override fun initUI() {}

}
