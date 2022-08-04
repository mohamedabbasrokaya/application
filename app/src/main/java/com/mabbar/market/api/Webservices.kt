package com.mabbar.market.api

import com.mabbar.market.ApiInterface
import retrofit2.Call
import retrofit2.http.GET

interface Webservices {
    @GET("api/products")
    fun getSources():Call<ApiInterface>
}