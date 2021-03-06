package com.sample.presentation.ui.auth.signin

import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_siginin.*


class SignInFragment : BaseFragment(), SignInView {

    @InjectPresenter
    lateinit var mPresenter: SignInPresenter

    override fun getLayoutResource() = R.layout.fragment_siginin

    override fun initUI() {
        val content = SpannableString(getString(R.string.description_sign_up))
        content.setSpan(UnderlineSpan(), 18, content.length, 0)
        content.setSpan(object : ClickableSpan() {
            override fun onClick(v: View?) {
                mPresenter.openSignUp()
            }
        }, 18, content.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        content.setSpan(ForegroundColorSpan(ContextCompat.getColor(context!! , R.color.orange)), 18, content.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvBottom.movementMethod = LinkMovementMethod.getInstance()
        tvBottom.text = content
        btnBack.setOnClickListener { mPresenter.onBack() }
        btnForgotPassword.setOnClickListener { mPresenter.openForgotPassword() }
    }

    companion object {
        fun newInstance() = SignInFragment()
    }

}