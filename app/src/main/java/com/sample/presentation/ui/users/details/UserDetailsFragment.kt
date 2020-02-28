package com.sample.presentation.ui.users.details

import android.annotation.SuppressLint
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.data.local.Constants.Arguments.USER
import com.sample.data.model.user.User
import com.sample.presentation.base.BaseFragment
import com.sample.utils.setImageCircleFromUrl
import kotlinx.android.synthetic.main.fragment_user_details.*

class UserDetailsFragment : BaseFragment(), UserDetailsView {

    @InjectPresenter
    lateinit var mPresenter: UserDetailsPresenter

    override fun getLayoutResource() = R.layout.fragment_user_details

    override fun initUI() {
        mPresenter.setArguments(arguments)
        btnBack.setOnClickListener { mPresenter.onBack() }
    }

    @SuppressLint("SetTextI18n")
    override fun showUser(user: User) {
        ivPhoto.setImageCircleFromUrl(user.picture.large)
        tvTitle.text = "${user.name.title}. ${user.name.first}"
        tvName.text = "${user.name.first} ${user.name.last}"
        tvAge.text = "Age: ${user.dob.age}"

        tvEmail.text = user.email
        tvPhone.text = user.phone

        tvStreet.text = user.location.street.toString()
    }

    companion object {

        fun newInstance(user: User): UserDetailsFragment {
            val fragment = UserDetailsFragment()
            val args = Bundle()
            args.putParcelable(USER, user)
            fragment.arguments = args
            return fragment
        }
    }

}