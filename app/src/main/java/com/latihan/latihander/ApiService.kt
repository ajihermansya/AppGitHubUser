package com.latihan.latihander

import com.latihan.latihander.model.ResponseRick
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getRick(): Call<ResponseRick>
}