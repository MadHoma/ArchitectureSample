package com.sample.presentation.ui.nasa.adapter

import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sample.R
import com.sample.data.model.nasa.PhotoItem
import com.sample.utils.setImageFromUrl

class RoverPhotoAdapter(layoutResId: Int, @Nullable data: List<PhotoItem>) :
    BaseQuickAdapter<PhotoItem, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: PhotoItem) {
        helper.setText(R.id.tv_cameraName, item.camera?.fullName)
        helper.setText(R.id.tv_roverName, item.rover?.name)
        helper.getView<AppCompatImageView>(R.id.iv_roverImage)
        item.imgSrc?.let {
            helper.getView<AppCompatImageView>(R.id.iv_roverImage).setImageFromUrl(it)
        }
    }
}