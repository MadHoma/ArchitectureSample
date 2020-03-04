package com.sample.presentation.ui.auth.signup

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

class SignUpFragment : BaseFragment(), SignUpView {

    @InjectPresenter
    lateinit var mPresenter: SignUpPresenter

    override fun getLayoutResource() = R.layout.fragment_siginup

    override fun initUI() {
        val content = SpannableString(getString(R.string.description_sign_in))
        content.setSpan(UnderlineSpan(), 25, content.length, 0)
        content.setSpan(object : ClickableSpan() {
            override fun onClick(v: View?) {
                mPresenter.openSignIn()
            }
        }, 25, content.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        content.setSpan(ForegroundColorSpan(ContextCompat.getColor(context!! , R.color.orange)), 25, content.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvBottom.movementMethod = LinkMovementMethod.getInstance()
        tvBottom.text = content
        btnBack.setOnClickListener { mPresenter.onBack() }
    }

    companion object {
        fun newInstance() = SignUpFragment()
    }

}