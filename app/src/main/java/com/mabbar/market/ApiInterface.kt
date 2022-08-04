package com.mabbar.market

import com.google.gson.annotations.SerializedName

data class ApiInterface(



    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Boolean? = null,
    @field:SerializedName("code")
    val code: Boolean? = null

)


data class DataItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("quantity")
    val quantity: Int? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("restaurant_id")
    val restaurantId: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)


