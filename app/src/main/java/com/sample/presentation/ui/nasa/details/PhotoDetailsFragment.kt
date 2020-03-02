package com.sample.presentation.ui.nasa.details

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.sample.R
import com.sample.data.local.Constants.Arguments.PHOTO_ITEM
import com.sample.data.model.nasa.PhotoItem
import com.sample.presentation.base.BaseFragment
import com.sample.utils.setImageFromUrl
import kotlinx.android.synthetic.main.fragment_details.*

class PhotoDetailsFragment : BaseFragment(), PhotoDetailsView {

    companion object {

        fun newInstance(item: PhotoItem): PhotoDetailsFragment {
            val fragment = PhotoDetailsFragment()
            val args = Bundle()
            args.putParcelable(PHOTO_ITEM, item)
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: PhotoDetailsPresenter

    override fun getLayoutResource(): Int = R.layout.fragment_details

    override fun initUI() {
        mPresenter.checkBundle(arguments)
        iv_roverImage.setOnClickListener { mPresenter.openMain() }
    }

    override fun setPhotoItem(item: PhotoItem) {
        tv_cameraName.text = item.camera?.fullName
        tv_roverName.text = item.rover?.name
        context?.let {
            item.imgSrc?.let { iv_roverImage.setImageFromUrl(it) }
        }
    }


}