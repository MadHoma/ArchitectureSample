package com.sample.presentation.ui.users.details

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.sample.data.model.user.User
import com.sample.presentation.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : BaseView {
    fun showUser(user: User)
}