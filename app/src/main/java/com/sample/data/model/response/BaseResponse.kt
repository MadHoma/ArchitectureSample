package com.sample.data.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(@SerializedName("results") val results: T)