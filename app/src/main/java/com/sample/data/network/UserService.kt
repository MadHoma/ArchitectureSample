package com.sample.data.network

import com.sample.data.model.response.BaseResponse
import com.sample.data.model.user.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api/")
    fun getMarsRoversPhotos(
        @Query("page") page: Int, @Query("results") results: Int
    ): Single<BaseResponse<List<User>>>
}