package com.sample.presentation.ui.auth.forgot

import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_siginin.*

class ForgotPasswordFragment : BaseFragment(), ForgotPasswordView {

    @InjectPresenter
    lateinit var mPresenter: ForgotPasswordPresenter

    override fun getLayoutResource() = R.layout.fragment_forgot_password

    override fun initUI() {
        btnBack.setOnClickListener { mPresenter.onBack() }
    }

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

}