package com.sample.presentation.ui.nasa.list

import com.sample.data.model.nasa.PhotoItem
import com.sample.presentation.base.BaseView


interface PhotoListView : BaseView {
    fun addItems(list: List<PhotoItem>)
}