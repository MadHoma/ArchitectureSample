package com.sample.presentation.ui.auth.signin

import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_siginin.*

class SignInFragment : BaseFragment(), SignInView {

    @InjectPresenter
    lateinit var mPresenter: SignInPresenter

    override fun getLayoutResource() = R.layout.fragment_siginin

    override fun initUI() {
        btnBack.setOnClickListener { mPresenter.onBack() }
    }

    companion object {
        fun newInstance() = SignInFragment()
    }

}