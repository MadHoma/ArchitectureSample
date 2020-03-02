package com.sample.presentation.ui.nasa.details

import com.sample.data.model.nasa.PhotoItem
import com.sample.presentation.base.BaseView


interface PhotoDetailsView : BaseView {
    fun setPhotoItem(item: PhotoItem)
}