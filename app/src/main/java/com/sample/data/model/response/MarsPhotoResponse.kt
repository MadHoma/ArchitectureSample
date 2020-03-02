package com.sample.data.model.response

import com.google.gson.annotations.SerializedName
import com.sample.data.model.nasa.PhotoItem
import java.util.*

data class MarsPhotoResponse(
    @SerializedName("photos")
    var photos: ArrayList<PhotoItem>?
)