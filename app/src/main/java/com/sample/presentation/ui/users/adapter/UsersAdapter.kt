package com.sample.presentation.ui.users.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sample.R
import com.sample.data.model.user.User
import com.sample.utils.setImageCircleFromUrl

class UsersAdapter : BaseQuickAdapter<User, BaseViewHolder>(R.layout.li_user) {
    override fun convert(helper: BaseViewHolder, item: User) {
        helper.getView<ImageView>(R.id.ivPhoto).setImageCircleFromUrl(item.picture.medium)
        helper.setText(R.id.tvName, "${item.name.first} ${item.name.last}")
        helper.setText(R.id.tvEmail, item.email)
        helper.setText(R.id.tvAge, "Age: ${item.dob.age}")
    }
}