package com.sample.presentation.ui.nasa.list

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.data.model.nasa.PhotoItem
import com.sample.R
import com.sample.presentation.base.BaseFragment
import com.sample.presentation.ui.nasa.adapter.RoverPhotoAdapter
import kotlinx.android.synthetic.main.bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_list.*

class PhotoListFragment : BaseFragment(), PhotoListView {

    companion object {
        fun newInstance(): PhotoListFragment {
            val fragment = PhotoListFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: PhotoListPresenter

    private var mAdapter: RoverPhotoAdapter? = null

    override fun getLayoutResource(): Int = R.layout.fragment_list

    override fun initUI() {
        initAdapter()

        btnSettings.isEnabled = false
        btnUsers.setOnClickListener { mPresenter.openUsers() }
        mPresenter.loadData()
    }

    private fun initAdapter() {
        rv_photos.layoutManager = LinearLayoutManager(context)
        mAdapter = RoverPhotoAdapter(R.layout.item_rover_photo, ArrayList())
        rv_photos.adapter = mAdapter
        mAdapter?.setEmptyView(R.layout.holder_empty, rv_photos.parent as ViewGroup)
        mAdapter?.setOnItemClickListener { adapter, _, position ->
            mPresenter.openDetailsScreen(adapter.getItem(position) as PhotoItem)
        }
    }

    override fun addItems(list: List<PhotoItem>) {
        mAdapter?.setNewData(list)
    }

}