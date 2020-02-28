package com.sample.presentation.ui.users.list

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.sample.data.model.user.User
import com.sample.presentation.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserListView: BaseView {
    fun addList(list: List<User>)
}