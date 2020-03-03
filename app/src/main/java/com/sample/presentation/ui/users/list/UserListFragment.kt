package com.sample.presentation.ui.users.list

import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.data.model.user.User
import com.sample.presentation.base.BaseFragment
import com.sample.presentation.ui.users.adapter.UsersAdapter
import kotlinx.android.synthetic.main.bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : BaseFragment(), UserListView {


    @InjectPresenter
    lateinit var mPresenter: UserListPresenter

    private val mUsersAdapter = UsersAdapter()

    override fun getLayoutResource() = R.layout.fragment_user_list

    override fun initUI() {
        rvUsers.adapter = mUsersAdapter
        mUsersAdapter.setOnItemClickListener { adapter, _, position ->
            mPresenter.openDetails(
                adapter.getItem(position) as User
            )
        }

        mPresenter.load(rvUsers)
        bottomNavigation.selectedItemId = R.id.navUsers
        bottomNavigation.setOnNavigationItemSelectedListener {
            if(it.itemId == R.id.navNasa)  mPresenter.openNasa()
            return@setOnNavigationItemSelectedListener true
        }

        btnSignIn.setOnClickListener { mPresenter.openSignIn() }

        swipeRefresh.setOnRefreshListener {
            mUsersAdapter.setNewData(arrayListOf())
            mPresenter.refresh()
        }
    }

    override fun addList(list: List<User>) {
        swipeRefresh.isRefreshing = false
        mUsersAdapter.addData(list)
    }


    companion object {
        fun newInstance() = UserListFragment()
    }
}